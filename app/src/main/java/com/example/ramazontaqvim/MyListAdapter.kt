package com.example.ramazontaqvim
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyListAdapter(private val context: Taqvim,  private val sana1: Array<String>, private val kun1: Array<String>,private val title: Array<String>,private val description2: Array<String> , private val hafata: Array<String>,)
    : ArrayAdapter<String>(context, R.layout.costum_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.costum_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val hafta = rowView.findViewById(R.id.icon) as TextView
        val subtitleText = rowView.findViewById(R.id.description2) as TextView
        val kun = rowView.findViewById(R.id.kun) as TextView
        val sana = rowView.findViewById(R.id.sana) as TextView

        titleText.text = kun1[position]
        hafta.text=hafata[position]
        subtitleText.text = description2[position]
        kun.text = title[position]
        sana.text = sana1[position]

        return rowView
    }
}

