package com.shrisai.web2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var requestQueue : RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)

        //simpleRequest1()
        simpleRequest2()


    }



    private fun simpleRequest2() {
        val request = StringRequest(
            "https://reqres.in/api/users?page=3",
            object : Response.Listener<String> {
                override fun onResponse(jsonResponse: String?) {

                    val response = Gson().fromJson<com.shrisai.web2.Response>(
                        jsonResponse,
                        com.shrisai.web2.Response::class.java
                    )

                    Log.e("tag", response.toString())

                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Log.e("tag", error.toString())
                }
            }
        )

        requestQueue.add(request)
    }


    private fun simpleRequest1() {
        val request = StringRequest(
            Method.GET,
            "https://bitcode.in",
            MySuccessResListener(),
            MyErrorListener()
        )

        requestQueue.add(request)
    }

    private inner class MySuccessResListener : Response.Listener<String> {
        override fun onResponse(response: String?) {
            Log.w("tag", response!!)
        }
    }

    private inner class MyErrorListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            Log.e("tag", error.toString())
        }
    }
}