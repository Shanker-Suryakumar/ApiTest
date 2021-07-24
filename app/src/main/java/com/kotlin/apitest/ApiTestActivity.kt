package com.kotlin.apitest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.apitest.services.ServiceBuilder
import com.kotlin.apitest.views.MyEndPoints
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiTestActivity : AppCompatActivity(), Callback<okhttp3.ResponseBody> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apitest)

        val categoriesService: MyEndPoints = ServiceBuilder.buildService(MyEndPoints::class.java)

        val callCategories: Call<ResponseBody> = categoriesService.getCategories()
        callCategories.enqueue(this)

        val callJsonResp: Call<ResponseBody> = categoriesService.getJsonResponse()
        callJsonResp.enqueue(this)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        println("-------------onFailure---------------")
    }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        println("-------------onResponse---------------")
        var json = JSONObject(response.body()?.string())
        println(json)
    }
}

