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
        var (firstWord,secondWord) = parseFullName(payload)
        firstWord = transliterateWord(firstWord)
        secondWord = transliterateWord(secondWord)
        return "$firstWord$devider$secondWord"
    }//it's work

            /*  fun transliteration(payload: String, devider:String = " "): String{
        var parts:List<String?> = payload.split(devider)
        parts.forEach { part ->
            it = transliterateWord(it)
        }
        return parts.joinToString(devider)
    }*/

    private fun transliterateWord(word:String?) : String?{
         if(word.isNullOrBlank()) return null
        var resultString:String = ""
        for(symbol in word.toCharArray()) resultString = resultString.plus(transliterate(symbol))
        return resultString


    }
    private fun transliterate(letter:Char):String{
        val isUpperCase:Boolean = letter.isUpperCase()
        val symbol = letter.toLowerCase()
        val resultString = when(symbol){
           'а'-> "a"
           'б'->"b"
           'в'-> "v"
           'г'-> "g"
           'д'-> "d"
           'е'-> "e"
           'ё'-> "e"
           'ж'-> "zh"
           'з'-> "z"
           'и'-> "i"
           'й'-> "i"
           'к'-> "k"
           'л'-> "l"
           'м'-> "m"
           'н'-> "n"
           'о'-> "o"
           'п'-> "p"
           'р'-> "r"
           'с'-> "s"
           'т'-> "t"
           'у'-> "u"
           'ф'-> "f"
           'х'-> "h"
           'ц'-> "c"
           'ч'-> "ch"
           'ш'-> "sh"
           'щ'-> "sh'"
           'ъ'-> ""
           'ы'-> "i"
           'ь'-> ""
           'э'-> "e"
           'ю'-> "yu"
           'я'-> "ya"
           else ->" "
        }
        return if(isUpperCase) resultString.toUpperCase() else resultString
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val name = firstName?.firstOrNull()
        val surname = lastName?.firstOrNull()
        return "$name$surname"
    }
}