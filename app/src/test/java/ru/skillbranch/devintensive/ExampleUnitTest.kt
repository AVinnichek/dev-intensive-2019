package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
//        val user1 = User("2","John","Wick")
//        val user2 = User("3","John","Silverhand",null,lastVisit = Date(),isOnline = true)

        println("$user ")
//        user1.printMe()
//        user2.printMe()
    }

    @Test
    fun test_factory(){
        val user = User.makeUser("John Weak")
        val user2 = User.makeUser("John Silver")
        val user3 = User.makeUser("John Gold")
        val user4 = User.makeUser(null)
        val user5 = User.makeUser(" ")
        val user6 = User.makeUser("Jhon")
        val user7 = User.makeUser("")
        println(user)
        println(user2)
        println(user3)
        println(user4)
        println(user5)
        println(user6)
        println(user7)
    }
}