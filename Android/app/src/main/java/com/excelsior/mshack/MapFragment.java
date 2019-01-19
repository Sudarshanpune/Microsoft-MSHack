package com.excelsior.mshack;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mmi.LicenceManager;
import com.mmi.MapView;
import com.mmi.MapmyIndiaMapView;
import com.mmi.layers.UserLocationOverlay;
import com.mmi.layers.location.GpsLocationProvider;
import com.mmi.layers.location.IMyLocationConsumer;
import com.mmi.layers.location.IMyLocationProvider;
import com.mmi.util.GeoPoint;

public class MapFragment extends Fragment {

    MapView mapView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflator, container, savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_map, null);

        LicenceManager.getInstance().setMapSDKKey("my7yci3zby43mtrz443ffnjuqs7t8dm7");
        LicenceManager.getInstance().setRestAPIKey("r7hd1ec5bhw5rned2bd4cc9r44a1q46t");

        mapView = ((MapmyIndiaMapView)view.findViewById(R.id.map)).getMapView();

        return view;
    }

    public void getCurrentLocation(final MapView mapView){
        UserLocationOverlay mLocationOverlay = new UserLocationOverlay(new GpsLocationProvider(getContext()), mapView);
        mLocationOverlay.enableMyLocation();
        mapView.getOverlays().add(mLocationOverlay);
        mapView.invalidate();
    }

    @Override
    public void onResume() {
        super.onResume();
        getCurrentLocation(mapView);
    }
}
