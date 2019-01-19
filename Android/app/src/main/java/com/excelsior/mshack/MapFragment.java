package com.excelsior.mshack;

import android.graphics.Canvas;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.FloatingActionButton;


import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.telemetry.Event;
import com.mapbox.android.telemetry.NavigationEventFactory;
import com.mapbox.android.telemetry.NavigationMetadata;
import com.mapbox.android.telemetry.NavigationState;
import com.mapbox.geojson.Point;
import com.mmi.LicenceManager;
import com.mmi.MapView;
import com.mmi.MapmyIndiaMapView;
import com.mmi.layers.OverlayManager;
import com.mmi.layers.UserLocationOverlay;
import com.mmi.layers.b;
import com.mmi.layers.location.GpsLocationProvider;
import com.mmi.apis.routing.RouteResponse;
import com.mmi.services.api.directions.legacy.MapmyIndiaDirectionsLegacy;
import com.mmi.services.api.directions.legacy.model.LegacyRouteResponse;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Date;

public class MapFragment extends Fragment {

    MapView mapView;
    MapmyIndiaMapView mmapView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflator, container, savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_map, null);

        LicenceManager.getInstance().setMapSDKKey("my7yci3zby43mtrz443ffnjuqs7t8dm7");
        LicenceManager.getInstance().setRestAPIKey("r7hd1ec5bhw5rned2bd4cc9r44a1q46t");


        mapView = ((MapmyIndiaMapView)view.findViewById(R.id.map)).getMapView();
        mmapView = view.findViewById(R.id.map);
        FloatingActionButton btn = view.findViewById(R.id.navigate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });
        return view;
    }

    public void getCurrentLocation(final MapView mapView){
        GpsLocationProvider provider = new GpsLocationProvider(getContext());
        UserLocationOverlay mLocationOverlay = new UserLocationOverlay(provider, mapView);
        mLocationOverlay.enableMyLocation();
        mapView.getOverlays().add(mLocationOverlay);
        mapView.invalidate();
    }


    @Override
    public void onResume() {
        super.onResume();
        getCurrentLocation(mapView);
    }

    public void navigate(){
        try {
            Response<LegacyRouteResponse> resp = new MapmyIndiaDirectionsLegacy.Builder()
                    .setOrigin(Point.fromLngLat(77,28))
                    .setDestination(Point.fromLngLat(77.23,28.1231))
                    .build().executeCall();

            Route


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
