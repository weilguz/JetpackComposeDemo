package com.example.composedemo.util

import com.example.composedemo.bean.Message

/**
 * 创建者   weilgu
 * 创建时间
 * 描述
 */
object SampleData {

    fun conversationSample(): List<Message>{
        val messageList = arrayListOf<Message>()
        (0..10).forEach {
            var msgContent = "aaaaaaaaaaaaaaaaaaaa,"
            val length: Int = (1..10).random()
            for (i in 0..length){
                msgContent += "bbbbbbbbbbbbbbbbbbb,"
            }
            messageList.add(Message("name$it","message: $msgContent"))
        }
        return messageList
    }
}