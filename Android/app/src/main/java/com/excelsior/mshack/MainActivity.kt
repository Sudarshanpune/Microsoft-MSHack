package com.excelsior.mshack

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.mapbox.mapboxsdk.MapmyIndia
import com.mmi.LicenceManager
import com.mmi.services.account.MapmyIndiaAccountManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LicenceManager.getInstance().mapSDKKey = "my7yci3zby43mtrz443ffnjuqs7t8dm7"
        LicenceManager.getInstance().restAPIKey = "r7hd1ec5bhw5rned2bd4cc9r44a1q46t"

        MapmyIndiaAccountManager.getInstance().restAPIKey = "r7hd1ec5bhw5rned2bd4cc9r44a1q46t"
        MapmyIndiaAccountManager.getInstance().mapSDKKey = "my7yci3zby43mtrz443ffnjuqs7t8dm7"
        MapmyIndiaAccountManager.getInstance().atlasGrantType = "client_credentials"
        MapmyIndiaAccountManager.getInstance().atlasClientId = "5DAD84w4c-D9yPWId0GNzmW-RRJdm0awDtySdkT-NdBZkq1AdBiNsw=="
        MapmyIndiaAccountManager.getInstance().atlasClientSecret = "7I5-OsHoU1hf8uyUl049idx1-L7sLzdAoPrapP8cfvjQVK3vTTb1hY16mIcO8ATR"
        MapmyIndia.getInstance(applicationContext)

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
