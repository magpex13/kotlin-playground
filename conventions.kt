data class Contact(val name: String, val email: String, val phoneNumber: String)

fun main() {
    val (name, _, phoneNumber) = Contact("Conejo1", "conejo@rabbits.com", "1234556")
    println(name)
    println(phoneNumber)
}