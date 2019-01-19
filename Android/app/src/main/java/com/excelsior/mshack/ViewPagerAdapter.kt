package com.excelsior.mshack

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var locationFragment = LocationFragment()
    var timeFragment = TimeFragment()
    var mapFragment = MapFragment()

    override fun getItem(i: Int): Fragment? {
        when(i) {
            0 -> return locationFragment
            1 -> return timeFragment
            2 -> return mapFragment
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }
}
