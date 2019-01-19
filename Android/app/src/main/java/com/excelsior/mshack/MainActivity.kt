package com.excelsior.mshack

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.mmi.LicenceManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LicenceManager.getInstance().mapSDKKey = "my7yci3zby43mtrz443ffnjuqs7t8dm7"
        LicenceManager.getInstance().restAPIKey = "r7hd1ec5bhw5rned2bd4cc9r44a1q46t"

        val pager = findViewById<ViewPager>(R.id.mainViewPager)

        pager.adapter = ViewPagerAdapter(supportFragmentManager)

        pager.setPageTransformer(false, ZoomOutPageTransformer())

        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
                return
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                return
            }

            override fun onPageSelected(p0: Int) {
                return
            }

        })

    }

}
