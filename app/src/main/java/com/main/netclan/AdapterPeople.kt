package com.main.netclan

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterPeople(private val context: Context,private val peopleArrayList:ArrayList<ModelPeople>):Adapter<AdapterPeople.HolderPeople>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPeople {
        val view =LayoutInflater.from(context).inflate(R.layout.row_people,parent,false)
        return HolderPeople(view)
    }

    override fun onBindViewHolder(holder: HolderPeople, position: Int) {
        val modelPeople = peopleArrayList[position]
        holder.name.text = modelPeople.name

    }

    override fun getItemCount(): Int {
        return peopleArrayList.size
    }

    inner class HolderPeople(itemView: View):ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.name)
    }
}