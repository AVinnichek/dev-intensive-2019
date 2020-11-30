package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?,String?>{
        val parts:List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

      //  firstName = if(firstName.isNullOrEmpty()) "InvalidName" else firstName
      //  lastName = if(lastName.isNullOrEmpty()) "InvalidLastname" else lastName

        return firstName to lastName
    }
}