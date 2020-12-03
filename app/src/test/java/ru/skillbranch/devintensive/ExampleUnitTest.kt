package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extentions.TimeUnits
import ru.skillbranch.devintensive.extentions.add
import ru.skillbranch.devintensive.extentions.format
import ru.skillbranch.devintensive.extentions.toUserView
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
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
        val user8 = user7.copy(id="10",firstName = "Antony",lastName = "vIN")
        println(user)
        println(user2)
        println(user3)
        println(user4)
        println(user5)
        println(user6)
        println(user7)
        println(user8)
    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val(id,firstName,lastName) = getUserInfo()

        println("$id $firstName $lastName")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("Vinnie Pooh")
        var user2 = user.copy(id="3",lastVisit = Date())

        if(user == user2){
            println("Equals data and hash${user.hashCode()} $user \n       ${user.hashCode()} $user2")
        }
        else{
            println("Not Equals data and hash ${user.hashCode()} $user \n" +
                    "           ${user2.hashCode()} $user2")
        }


        if(user === user2){
            println("Equals address ${System.identityHashCode(user)}  \n       ${System.identityHashCode(user2)} ")
        }
        else{
            println("Not Equals address ${System.identityHashCode(user)}  \n" +
                    "           ${System.identityHashCode(user2)}")
        }

        println(user2.lastVisit?.format())
    }

    @Test
    fun test_copy_with_date_add(){
        val user = User.makeUser("Vinny Pooh")
        val user2 = user.copy(lastVisit = Date().add(
                -2,
                TimeUnits.SECOND
        ))
        val user3 = user.copy(lastVisit = Date().add(2,TimeUnits.DAY))

        println("""
        ${user.lastVisit?.format()}
        ${user2.lastVisit?.format()}
        ${user3.lastVisit?.format()}
    """.trimIndent())
    }

    @Test
    fun test_data_mapping(){
        val user = User.makeUser("Винничек")
        println("$user")
        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Винничек")
        val txtMessage = BaseMessage.makeMessage(user, Chat("1"),payload = "any text message",type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("1"),payload = "any image url",type = "image")

        println("${txtMessage.formatMessage()}")
        println("${imageMessage.formatMessage()}")
    }
}

