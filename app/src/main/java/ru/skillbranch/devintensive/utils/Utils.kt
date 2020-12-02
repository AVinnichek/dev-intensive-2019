package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?,String?>{
        val parts:List<String>? = fullName?.split(" ")
        val firstName = checkEmpty(parts?.getOrNull(0))
        val lastName = checkEmpty(parts?.getOrNull(1))

        return firstName to lastName
    }

    private fun checkEmpty(inputString:String?) = if(inputString.isNullOrBlank()) null else inputString

    fun transliteration(payload: String, devider:String = " "): String {
        TODO("Make implementation")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("Make implementation")
    }
}