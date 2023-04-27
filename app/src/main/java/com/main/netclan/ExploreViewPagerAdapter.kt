package com.main.netclan

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ExploreViewPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> peopleFragment()
            1 -> officeFragment()
            2 -> marketFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null

    }

    @SuppressLint("MissingInflatedId")
    fun getTabView(position: Int): View {
        val view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
        val icon = view.findViewById<ImageView>(R.id.icon)

        when (position) {
            0 -> {
                icon.setImageResource(R.drawable.people)
            }
            1 -> {
                icon.setImageResource(R.drawable.office)
            }
            2 -> {
                icon.setImageResource(R.drawable.market)
            }
        }

        return view
    }

}
