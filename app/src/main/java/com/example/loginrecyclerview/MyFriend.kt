package com.example.loginrecyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyFriend (
    @PrimaryKey(autoGenerate = true)
    val temanId : Int? = null,
    val nama : String,
    val email : String,
    val telp: String,
    var date: String
    )