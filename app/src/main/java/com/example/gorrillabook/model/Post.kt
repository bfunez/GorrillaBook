package com.example.gorrillabook.model

data class Post (val id : Int, val first_name : String, val last_name : String , val post_body : String,  val unix_timestamp : Long){
    fun timeStampToDate(): String {
        return java.time.format.DateTimeFormatter.ISO_INSTANT
            .format(java.time.Instant.ofEpochSecond(unix_timestamp))
    }
}