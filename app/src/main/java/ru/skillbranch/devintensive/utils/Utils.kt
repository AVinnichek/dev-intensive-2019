package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?,String?>{
        val parts:List<String>? = fullName?.split(" ")
        val firstName = checkEmpty(parts?.getOrNull(0))
        val lastName = checkEmpty(parts?.getOrNull(1))

      //  firstName = if(firstName.isNullOrEmpty()) "InvalidName" else firstName
      //  lastName = if(lastName.isNullOrEmpty()) "InvalidLastname" else lastName

        return firstName to lastName
    }

    private fun checkEmpty(inputString:String?) : String? {
        return if(inputString.isNullOrBlank()) null else inputString
    }
}