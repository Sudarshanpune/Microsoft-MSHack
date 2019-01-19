package com.excelsior.mshack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mmi.LicenceManager
import com.mmi.MapmyIndiaMapView
import com.mmi.util.GeoPoint



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LicenceManager.getInstance().mapSDKKey = "my7yci3zby43mtrz443ffnjuqs7t8dm7"
        LicenceManager.getInstance().restAPIKey = "r7hd1ec5bhw5rned2bd4cc9r44a1q46t"

        val mapmyIndiaMapView = findViewById<MapmyIndiaMapView>(R.id.map)
        val mapView = mapmyIndiaMapView.mapView

        val geoPoint = GeoPoint(48.8583, 2.0, 2944.0)
        mapView.setCenter(geoPoint)
    }

}
