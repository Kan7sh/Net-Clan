package com.main.netclan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.DynamicDrawableSpan
import android.text.style.ImageSpan
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar=findViewById(R.id.toolbar)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val subtitle = SpannableStringBuilder()
        val icon = getDrawable(R.drawable.ic_baseline_location_on_24)?.apply {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)
        }
        icon?.let {
            subtitle.append("  ")
            subtitle.setSpan(
                ImageSpan(it, DynamicDrawableSpan.ALIGN_CENTER),
                subtitle.length - 1,
                subtitle.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        subtitle.append(" Amritsar")
        toolbar.subtitle = subtitle


        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.inflateMenu(R.menu.toolbar_menu)
     //   toolbar.inflateMenu(R.menu.right_menu)

        bottomNavigationView = findViewById(R.id.bottomNav)


        loadRefineFragment()

        bottomNavigationView.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.bottomMenuRefine -> {
                    loadRefineFragment()
                }
                R.id.bottomMenuExplore -> {
                    loadExploreFragment()
                }
            }
            return@setOnItemSelectedListener true
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }


    private fun loadRefineFragment(){
        val refineFragment = RefineFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
   //     fragmentTransaction.setCustomAnimations( R.anim.slide_in_left,R.anim.slide_out_right)
        fragmentTransaction.replace(R.id.frameLayout,refineFragment,"RefineFragment")
        fragmentTransaction.commit()
    }

    private fun loadExploreFragment(){
        val exploreFragment = ExploreFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
     //   fragmentTransaction.setCustomAnimations(R.anim.slide_out_left, R.anim.slide_in_right)
        fragmentTransaction.replace(R.id.frameLayout, exploreFragment,"ExploreFragment")
        fragmentTransaction.commit()
    }

}