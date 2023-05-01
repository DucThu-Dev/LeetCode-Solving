package design_pattern.structure_patterns.kotlin

interface UserService {
    fun load()

    fun insert()
}

class UserServiceImpl : UserService {
    override fun load() {
        println("User Service Loading")
    }

    override fun insert() {
        println("User Service Inserting")
    }
}

class UserServiceProxy(private val isAdmin: Boolean) : UserService {
    private val userService: UserService by lazy {
        UserServiceImpl()
    }

    override fun load() {
        userService.load()
    }

    override fun insert() {
        if (isAdmin) userService.insert()
    }

    fun validateAdmin(): Boolean = isAdmin
}

class ClientSide {
    private val userService: UserService by lazy {
        UserServiceProxy(true)
    }

    fun updateInfo() {
        userService.load()
        userService.insert()
    }
}

fun main() {
    val client = ClientSide()
    client.updateInfo()
}