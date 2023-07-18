package com.shrisai.web2

import com.google.gson.annotations.SerializedName

data class Response(
@SerializedName("page")
    var currentPage: Int=0,
@SerializedName("data")
    var users : ArrayList<User>
    
)
