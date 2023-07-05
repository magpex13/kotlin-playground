//Using delegates
package board

import board.Direction.*
import java.lang.IllegalArgumentException

data class Cell(val i: Int, val j: Int) {
    override fun toString()= "($i, $j)"
}

enum class Direction {
    UP, DOWN, RIGHT, LEFT;

    fun reversed() = when (this) {
        UP -> DOWN
        DOWN -> UP
        RIGHT -> LEFT
        LEFT -> RIGHT
    }
}

interface SquareBoard {
    val width: Int

    fun getCellOrNull(i: Int, j: Int): Cell?
    fun getCell(i: Int, j: Int): Cell

    fun getAllCells(): Collection<Cell>

    fun getRow(i: Int, jRange: IntProgression): List<Cell>
    fun getColumn(iRange: IntProgression, j: Int): List<Cell>

    fun Cell.getNeighbour(direction: Direction): Cell?
}

interface GameBoard<T> : SquareBoard {

    operator fun get(cell: Cell): T?
    operator fun set(cell: Cell, value: T?)

    fun filter(predicate: (T?) -> Boolean): Collection<Cell>
    fun find(predicate: (T?) -> Boolean): Cell?
    fun any(predicate: (T?) -> Boolean): Boolean
    fun all(predicate: (T?) -> Boolean): Boolean
}

class SquareBoardImpl(override val width: Int): SquareBoard {
    private val data: List<List<Cell>> = (1..width).map { first -> (1..width).map { second -> Cell(first, second) } }

    private fun isOutBounds(i: Int, j: Int): Boolean = i - 1 < 0 || j - 1 < 0 || i - 1 >= this.width || j - 1 >= this.width

    override fun getCellOrNull(i: Int, j: Int): Cell? = if(isOutBounds(i, j)) null else this.data[i - 1][j - 1]

    override fun getCell(i: Int, j: Int): Cell = if(isOutBounds(i, j)) throw IllegalArgumentException() else this.data[i - 1][j - 1]

    override fun getAllCells(): Collection<Cell> = this.data.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val range = IntProgression.fromClosedRange(jRange.first - 1, if(jRange.last > this.width) this.width - 1 else jRange.last - 1, jRange.step)
        return this.data[i - 1].slice(range)
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val range = IntProgression.fromClosedRange(iRange.first - 1, if(iRange.last > this.width) this.width - 1 else iRange.last - 1, iRange.step)
        return this.data.slice(range).map { it[j - 1] }
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        val cellPosition = Pair(this.i, this.j)

        return when(direction) {
            UP -> this@SquareBoardImpl.getCellOrNull(cellPosition.first - 1, cellPosition.second)
            DOWN -> this@SquareBoardImpl.getCellOrNull(cellPosition.first + 1, cellPosition.second)
            RIGHT -> this@SquareBoardImpl.getCellOrNull(cellPosition.first, cellPosition.second + 1)
            LEFT -> this@SquareBoardImpl.getCellOrNull(cellPosition.first, cellPosition.second - 1)
        }
    }
}

class GameBoardImpl<T>(override val width: Int, val squareBoard: SquareBoard) : GameBoard<T>, SquareBoard by squareBoard {

    private val dictionary = mutableMapOf<Cell, T?>()

    init {
        squareBoard.getAllCells().forEach {
            dictionary[it] = null
        }
    }
    override fun getCellOrNull(i: Int, j: Int): Cell? = this.squareBoard.getCellOrNull(i,j)

    override fun getCell(i: Int, j: Int): Cell = this.squareBoard.getCell(i, j)

    override fun getAllCells(): Collection<Cell> = this.squareBoard.getAllCells()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> = this.squareBoard.getRow(i, jRange)

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> = this.squareBoard.getColumn(iRange, j)

    override operator fun get(cell: Cell): T? = dictionary[cell]

    override operator fun set(cell: Cell, value: T?) {
        dictionary[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> = dictionary.filter { predicate(it.value) }.keys
    override fun find(predicate: (T?) -> Boolean): Cell? = filter(predicate).firstOrNull()
    override fun any(predicate: (T?) -> Boolean): Boolean = dictionary.any { predicate(it.value) }
    override fun all(predicate: (T?) -> Boolean): Boolean = dictionary.all { predicate(it.value) }
}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width, createSquareBoard(width))
