package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
        val id: String,
        val from:User?,
        val chat:Chat,
        val isComming:Boolean = false,
        val date:Date = Date()
) {

    abstract fun formatMessage():String
    companion object AbstractFactory{
        var lastId = -1;
        fun makeMessage(
                user: User?,
                chat: Chat,
                date: Date = Date(),
                type: String = "text",
                payload: Any?
        ):BaseMessage{
            lastId++;
            return when(type){
                "text" -> TextMessage("$lastId",from = user,chat = chat,date = date,text = payload as String)
                else -> ImageMessage(id = "$lastId",from = user,chat = chat,date = date,image = payload as String)
            }

        }
    }
}