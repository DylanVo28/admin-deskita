package com.example.admin_deskita

import android.app.Activity
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.net.URL


class ProductsAdapter(private val context: Activity, private val title: ArrayList<String>, private val description: ArrayList<String>, private val imgurl: ArrayList<String>)
    : ArrayAdapter<String>(context, R.layout.list_product, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_product, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val imageView = rowView.findViewById(R.id.icon) as ImageView
        val subtitleText = rowView.findViewById(R.id.description) as TextView
        val url=URL(imgurl[position])
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        titleText.text = title[position]
        imageView.setImageBitmap(bmp)
        subtitleText.text = description[position]

        return rowView
    }
}