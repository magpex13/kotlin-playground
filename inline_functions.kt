fun getEmail(): String? = "conejo@hotmail.com"

open class User(val id: Int, val name: String)
interface Session {
    val user: User
}

class FacebookUser(val fid: Int, name: String): User(fid, name)
class TwitterUser: User {
    constructor(tid: Int,tname: String): super(tid, tname)
}

fun getUser(session: Session) {
    // val user = session.user
    // if(user is FacebookUser) {
    //     println(user.id)
    // }

    (session.user as? FacebookUser)?.let {
        println("It's the user!")
    }
}

fun main() {
    val email = getEmail()
    email?.let{ e -> println(e) }

    val facebookUser = FacebookUser(5, "cone1")
    val fid1 = facebookUser.id.takeIf{ it > 2 }
    val fname = facebookUser.name.takeIf(String::isNotEmpty)
    val fid2 = facebookUser.id.takeUnless{ it > 2}
    println(fid1)
    println(fname)
    println(fid2)

    val twitterUser = TwitterUser(10, "cone2")
    repeat(5) { index ->
        println("${twitterUser.name}+$index")
    }
}