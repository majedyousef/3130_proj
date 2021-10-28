package com.example.csci3130project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.csci3130project.databinding.ActivityMapsBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/*
The code below was originally created by Shakuntala Khatri
It was further edited to this project by Benjamin Chui
The original code is available at: https://git.cs.dal.ca/prof3130/google-map-advance-demo
Date Accessed: 26th Oct. 2021
*/

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final float DEFAULT_ZOOM = 17f;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    private Boolean mLocationPermissionGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starts");
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getLocationPermission();
        Log.d(TAG, "onCreate: Ends");
    }

    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission : starts");
        String[] permissions = {FINE_LOCATION, COURSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
                Log.d(TAG, "getLocationPermission : Permissions already granted");
                initMap();
            } else {
                ActivityCompat.requestPermissions(this,
                        permissions, LOCATION_PERMISSION_REQUEST_CODE);
                Log.d(TAG, "getLocationPermission : Request for permissions");
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    permissions, LOCATION_PERMISSION_REQUEST_CODE);
            Log.d(TAG, "getLocationPermission : Request for permissions");
        }
        Log.d(TAG, "getLocationPermission :  ends");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: Requesting for permissions");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionGranted = true;
                    Log.d(TAG, "onRequestPermissionsResult: permissions given by user");
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    private void initMap() {
        Log.d(TAG, "initMap: starts");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Log.d(TAG, "initMap: ends");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: starts");
        mMap = googleMap;
        Toast.makeText(this, "Location Services Are Active", Toast.LENGTH_SHORT).show();
        if (mLocationPermissionGranted) {
            Log.d(TAG, "onMapReady: getting Device current location!!");
            getDeviceLocation();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
        }
    }

    public void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: starts");
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
            if(mLocationPermissionGranted){
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "getDeviceLocation: onComplete: found location");
                            Location currentLocation = (Location) task.getResult();
                            if(currentLocation != null) {
                                Log.d(TAG, "getDeviceLocation: currentLocation Lattitude: " + currentLocation.getLatitude());
                                Log.d(TAG, "getDeviceLocation: currentLocation Longitude: " + currentLocation.getLongitude());
                                moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                        DEFAULT_ZOOM,"current location");
                            }else
                                Log.d(TAG, "getDeviceLocation: Current location is null");
                        }else {
                            Log.d(TAG, "getDeviceLocation: Current location is null");
                            Toast.makeText(MapsActivity.this, "Unable to get curent location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException se){
            Log.d(TAG, "getDeviceLocation: SecurityException: =" + se.getMessage());
        }
        Log.d(TAG, "getDeviceLocation: ends");
    }

    public void moveCamera(LatLng latlng, float zoom, String title){
        Log.d(TAG, "moveCamera: starts with latitude: "+ latlng.latitude + " and Longitude: " + latlng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,zoom));
        MarkerOptions options = new MarkerOptions()
                .position(latlng)
                .title(title);
        mMap.addMarker(options);
    }

    // Check Services are working fine or not
    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: Google Services is working fine");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapsActivity.this);

        if (available == ConnectionResult.SUCCESS) {
            Log.d(TAG, "isServicesOK: Google play services is working");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(TAG, "isServicesOK: An error occurred but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MapsActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "You cannot make map request", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}