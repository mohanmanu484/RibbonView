package com.mohan.indicator.ribbon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mohan.indicator.tagview.R

class MainActivity : AppCompatActivity() {

   lateinit var recyclerView:RecyclerView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(ItemDecor())
        recyclerView.adapter=ListAdapter(arrayListOf(Item(R.drawable.image1,"Hotel one","30% off"),
                Item(R.drawable.image1,"Hotel two","50% off"),
                Item(R.drawable.image1,"Hotel three","Book now and Save 30%")

                ))





    }
}
