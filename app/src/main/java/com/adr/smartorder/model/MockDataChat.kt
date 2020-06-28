package com.adr.smartorder.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class MockDataChat {
    @Parcelize
    data class MockDataChat (
        val idTo: String = "",
        val idFrom: String = "",
        val message: String = "",
        val date: String = ""
    ): Parcelable

    val chatData1 = listOf(
        MockDataChat("user1", "me", "1", "12-11-2010: 20:10"),
        MockDataChat("me", "user1", "2", "12-11-2010: 22:10"),
        MockDataChat("user1", "me", "3", "13-11-2010: 09:10"),
        MockDataChat("user1", "me", "4", "14-11-2010: 10:10"),
        MockDataChat("me", "user1", "5", "14-11-2010: 13:12")
    )

    val chatData2 = listOf(
        MockDataChat("user2", "me", "1", "12-11-2010: 20:10"),
        MockDataChat("me", "user2", "2", "12-11-2010: 22:10"),
        MockDataChat("user2", "me", "3", "13-11-2010: 09:10"),
        MockDataChat("user2", "me", "4", "14-11-2010: 10:10"),
        MockDataChat("me", "user2", "5", "14-11-2010: 13:12")
    )

    val chatData3 = listOf(
        MockDataChat("user3", "me", "1", "12-11-2010: 20:10"),
        MockDataChat("me", "user3", "2", "12-11-2010: 22:10"),
        MockDataChat("user3", "me", "3", "13-11-2010: 09:10"),
        MockDataChat("user3", "me", "4", "14-11-2010: 10:10"),
        MockDataChat("me", "user3", "5", "14-11-2010: 13:12")
    )

    val listChatData = listOf(chatData1, chatData2, chatData3)
}