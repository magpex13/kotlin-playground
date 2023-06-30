package rationals

import java.lang.IllegalArgumentException
import java.math.BigInteger

//divBy infix
infix fun <T: Number> T.divBy(other: T): Rational = Rational(BigInteger.valueOf(this.toLong()), BigInteger.valueOf(other.toLong()))

//String toRational() function
fun String.toRational(): Rational {
    val splitString = this.split('/').map { it.toBigInteger() }
    val n = splitString[0]
    val d = splitString.getOrElse(1) { BigInteger.ONE }

    val sign = if(splitString.size == 2 && d < BigInteger.ZERO) -BigInteger.ONE else BigInteger.ONE

    return Rational(n * sign , d * sign)
}

//Rational class
data class Rational(val n: BigInteger, val d: BigInteger): Comparable<Rational> {
    init {
        if(d < BigInteger.ZERO) throw IllegalArgumentException()
    }
    override fun compareTo(other: Rational): Int {
        if(this.d == other.d) return this.n.compareTo(other.n)
        val thisRational = (other.d * this.n)
        val otherRational = (this.d * other.n)
        return thisRational.compareTo(otherRational)
    }

    override fun toString(): String {
        val (n, d) = this.toNormalize()
        var dToString = ""
        if(d != BigInteger.ONE) {
            dToString = "/${d}"
        }
        return "${n}${dToString}"
    }

    private fun toNormalize(): Rational {
        val gcd = this.n.gcd(this.d)
        return Rational(this.n / gcd, this.d / gcd)
    }

    override fun equals(other: Any?): Boolean {
        val (othern, otherd) = (other as Rational).toNormalize()
        val (thisn, thisd) = this.toNormalize()
        return thisn == othern && thisd == otherd
    }
}

//Rational Operators
operator fun Rational.plus(other: Rational): Rational = Rational((this.d * other.n) + (this.n * other.d), this.d * other.d)
operator fun Rational.minus(other: Rational): Rational = Rational((this.d * -other.n) + (this.n * other.d), this.d * other.d)
operator fun Rational.times(other: Rational): Rational = Rational(this.n * other.n, this.d * other.d)
operator fun Rational.div(other: Rational): Rational = Rational(this.n * other.d, this.d * other.n)
operator fun Rational.unaryMinus(): Rational = Rational(-this.n, this.d)
operator fun Rational.inc(): Rational = this + Rational(BigInteger.ONE, BigInteger.TEN)

class RationalIterator(val start: Rational, val endInclusive: Rational): Iterator<Rational> {
    var initValue = start
    override fun hasNext(): Boolean = initValue <= endInclusive
    override fun next(): Rational = initValue++
}

class RationalRange(override val start: Rational, override val endInclusive: Rational): ClosedRange<Rational>, Iterable<Rational> {
    override fun iterator(): Iterator<Rational> = RationalIterator(start, endInclusive)
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}