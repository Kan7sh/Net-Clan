package com.main.netclan

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.content.ContextCompat
import com.google.android.material.slider.Slider


class RefineFragment : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var slider: Slider
    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_refine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spinnerArray = arrayOf("Available | Hey Let Us Connect")

        super.onViewCreated(view, savedInstanceState)
 /*       slider = view.findViewById(R.id.slider)
        val tooltipPopup = slider.getTooltipPopup()
        tooltip?.let {
            val parent = it.parent as View
            parent.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
        }*/
        spinner = view.findViewById(R.id.my_spinner)
        val adapter = ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }


}