package com.ferdinand.covid

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrecautionAdapter(var precautionList:ArrayList<PrecautionModel>): RecyclerView.Adapter<PrecautionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrecautionAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return precautionList.size
    }

    override fun onBindViewHolder(holder: PrecautionAdapter.ViewHolder, position: Int) {
        val precautionmodel = precautionList[position]
        holder.bind(precautionmodel)
    }


    class ViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptomes,viewGroup,false)){

        fun bind(precautionm: PrecautionModel){

            val symptit = itemView.findViewById<TextView>(R.id.symptomtitre)
            val symptdes = itemView.findViewById<TextView>(R.id.symptomdesc)
            val symptimg = itemView.findViewById<ImageView>(R.id.imagesymp)

            symptit.text = precautionm.precautiontitre
            symptdes.text = precautionm.precautiondescript
            symptimg.setImageResource(precautionm.precautionimage)

        }

    }




}