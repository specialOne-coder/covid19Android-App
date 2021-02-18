package com.ferdinand.covid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class SymptomAdapter(var symptomList:ArrayList<SymptomModel>):RecyclerView.Adapter<SymptomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomAdapter.ViewHolder {
      val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return symptomList.size
    }

    override fun onBindViewHolder(holder: SymptomAdapter.ViewHolder, position: Int) {
         val symptomodel = symptomList[position]
        holder.bind(symptomodel)
    }


    class ViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup):
         RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptomes,viewGroup,false)){

        fun bind(symptomModel: SymptomModel){

            val symptit = itemView.findViewById<TextView>(R.id.symptomtitre)
            val symptdes = itemView.findViewById<TextView>(R.id.symptomdesc)
            val symptimg = itemView.findViewById<ImageView>(R.id.imagesymp)

            symptit.text = symptomModel.symptomtitre
            symptdes.text = symptomModel.symptomdesc
            symptimg.setImageResource(symptomModel.imagesymp)
        }

    }




}
