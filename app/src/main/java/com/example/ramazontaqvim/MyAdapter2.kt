package com.example.ramazontaqvim

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter2(private val context: Activity,private val text_costum:Array<String>,private val image_cost:Array<Int>):
    ArrayAdapter<String>(context,R.layout.costum_list2,text_costum){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater=context.layoutInflater
        val row=inflater.inflate(R.layout.costum_list2,null,true)


        val textt=row.findViewById<TextView>(R.id.text_costum) as TextView
        val imagee=row.findViewById<ImageView>(R.id.image_costum2) as ImageView

        textt.text=text_costum[position]
        imagee.setImageResource(image_cost[position])

        return row
    }

}