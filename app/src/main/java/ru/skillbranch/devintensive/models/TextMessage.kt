package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extentions.humanizeDiff
import java.util.*

class TextMessage(
        id: String,
        from:User?,
        chat:Chat,
        isComming:Boolean = false,
        date: Date = Date(),
        var text:String?
) : BaseMessage(id,from,chat,isComming,date){
    override fun formatMessage(): String  = "id: $id ${from?.firstName} " +
            "${if (isComming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"

}

