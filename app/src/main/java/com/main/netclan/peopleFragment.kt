package com.main.netclan

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class peopleFragment : Fragment() {

    private lateinit var rv:RecyclerView
    private lateinit var mContext:Context
    private lateinit var peopleArrayList:ArrayList<ModelPeople>
    private lateinit var adapterPeople: AdapterPeople


    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
        val view = inflater.inflate(R.layout.fragment_people, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rView)
        peopleArrayList = ArrayList<ModelPeople>()
        adapterPeople = AdapterPeople(mContext,peopleArrayList)
        rv.adapter = adapterPeople

        var modelPeople1 = ModelPeople("Kanish Chhabra")
        peopleArrayList.add(modelPeople1)
        var modelPeople2 = ModelPeople("Akshay Chhabra")
        peopleArrayList.add(modelPeople2)
        var modelPeople3 = ModelPeople("Ravish Chhabra")
        peopleArrayList.add(modelPeople3)
        adapterPeople.notifyDataSetChanged()
    }

}