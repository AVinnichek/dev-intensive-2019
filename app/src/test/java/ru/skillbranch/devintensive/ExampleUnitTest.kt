package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extentions.*
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
        val user = User.makeUser("")
        println("$user")
        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_to_initials(){
        val user = User.Builder().id("1")
                .firstName(null)
                .lastName("Винничек")
                .avatar(null)
                .rating(95)
                .respect(96)
                .lastVisit(Date().add(-2,TimeUnits.HOUR))
                .isOnline(true)
                .build()
        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_stripHtml(){
        var string:String = "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>"
        println(string.stripHtml())
    }



    @Test
    fun test_pattern_builder(){
        val user = User.Builder().id("1")
                .firstName("Антон")
                .lastName("Винничек")
                .avatar(null)
                .rating(95)
                .respect(96)
                .lastVisit(Date().add(-2,TimeUnits.HOUR))
                .isOnline(false)
                .build()
        println(user)

        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_string_truncate(){
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        println("A     ".truncate(3))
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Винничек")
        val txtMessage = BaseMessage.makeMessage(user, Chat("1"),payload = "any text message",type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("1"),payload = "any image url",type = "image")

        val user1 = User.Builder().id("1")
                .firstName("Антон")
                .lastName("Винничек")
                .avatar(null)
                .rating(95)
                .respect(96)
                .lastVisit(Date().add(-2,TimeUnits.HOUR))
                .isOnline(true)
                .build()

        val txtMessage1 = BaseMessage.makeMessage(user1, Chat("1"),payload = "any text message",type = "text")
        val imageMessage1 = BaseMessage.makeMessage(user1, Chat("1"),payload = "any image url",type = "image")

        println("${txtMessage.formatMessage()}")
        println("${imageMessage.formatMessage()}")

        println("${txtMessage1.formatMessage()}")
        println("${imageMessage1.formatMessage()}")
    }

    @Test
    fun test_plural(){
        for (second in 0..60) {
            println(TimeUnits.SECOND.plural(second))
        }

        for (minute in 0..60) {
            println(TimeUnits.MINUTE.plural(minute))
        }

        for (hour in 0..25) {
            println(TimeUnits.HOUR.plural(hour))
        }

        for(day in 0 .. 340) {
            println(TimeUnits.DAY.plural(day))
        }
    }
}

