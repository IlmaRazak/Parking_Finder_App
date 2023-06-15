package com.example.designprojects92060869;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.designprojects92060869.databinding.ActivityMapsBinding;

import java.util.List;
//  This activity displays a Google Map with a marker for a specific location (Kattankudy).
//  It also handles location permissions and geocoding to obtain the
//  longitude, latitude, and country name of the location.

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    List<Address> listGeoCoder;
    private static final int LOCATION_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Check if location permission is granted
        if (isLocationPermissionGranted()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else {
            requestLocationPermission();
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        try {
            listGeoCoder = new Geocoder(this).getFromLocationName("Kattankudy", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get Longitude, Latitude, CountryName
        double longitude = listGeoCoder.get(0).getLongitude();
        double latitude = listGeoCoder.get(0).getLatitude();
        String countryName = listGeoCoder.get(0).getCountryName();

        // Create Log
        Log.i("GOOGLE_MAP_TAG", "Address has longitude: " + longitude + " Latitude: " + latitude + " Country Name: " + countryName);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Request runtime permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

        // Add a marker
        LatLng kattankudy = new LatLng(7.685614204108742, 81.72572088766984);
        mMap.addMarker(new MarkerOptions().position(kattankudy).title("Kattankudy"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kattankudy, 18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    private boolean isLocationPermissionGranted() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_CODE);
    }
}

