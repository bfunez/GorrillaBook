package com.example.gorrillabook.model

import java.text.SimpleDateFormat
import java.util.*

data class Post (val id : Int, val first_name : String, val last_name : String , val post_body : String,  val unix_timestamp : Long, val image: String?){
    fun getMMddyyyyFormattedDate(): String {
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return sdf.format(Date(unix_timestamp * 1000))
    }
}