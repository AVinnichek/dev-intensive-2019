package ru.skillbranch.devintensive.extentions

fun String.truncate(limit:Int = 16):String{
    val cutted = this.length > limit
    val resultString = this.take(limit).dropLastWhile { !it.isLetter() }
    return if(cutted) resultString.plus("...") else resultString
}