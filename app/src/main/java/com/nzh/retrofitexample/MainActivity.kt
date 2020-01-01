package com.nzh.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nzh.retrofitexample.mode.Region
import com.ucsmonywataungthu.org.Network.APIInitiate
import com.ucsmonywataungthu.org.Network.APIService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiService: APIService = APIInitiate.client.create((APIService::class.java))
    var regionList:List<Region>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call=apiService.getRegion()
        call.enqueue(object :retrofit2.Callback<List<Region>>{
            override fun onFailure(call: Call<List<Region>>, t: Throwable) {
            }
            override fun onResponse(call: Call<List<Region>>, response: Response<List<Region>>) {
                regionList=response.body()

                Log.i("Region Size ::",regionList!!.size.toString())
            }
        })
    }
}
