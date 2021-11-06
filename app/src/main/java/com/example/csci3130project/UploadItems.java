package com.example.csci3130project;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.gms.location.LocationRequest;

public class UploadItems extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText mItemName, mItemDescription;
    EditText mItemValue;
    Spinner mItemCat;
    Button mButton;
    private Double [] location;
    private com.google.android.gms.location.LocationRequest locationRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_items);
        mItemName = (EditText) findViewById(R.id.uploadItemName);
        mItemValue = (EditText) findViewById(R.id.uploadItemValue);
        mItemDescription = (EditText) findViewById(R.id.uploadItemdesc);
        mButton = (Button) findViewById(R.id.uploadBtn);
        mItemCat = (Spinner) findViewById(R.id.uploadItemCat);
        locationRequest = com.google.android.gms.location.LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDeviceLocation();
//                String itemName = mItemName.getText().toString().trim();
//                String itemDescription = mItemDescription.getText().toString().trim();
//                int itemValue = Integer.parseInt(mItemValue.getText().toString().trim());
//
//                String itemCategory = mItemCat.getSelectedItem().toString().trim();
//                Double [] longLat = getCurrentLocation();
//                System.out.println("Longitude: "+longLat[0]+" latitude: "+longLat[1]);
//                Item item = new Item(itemName, itemDescription, itemCategory, itemValue, longLat[0], longLat[1]);
//                DatabaseItem db = new DatabaseItem();
//                db.addItem(item).addOnSuccessListener(success -> {
//                    Toast.makeText(getApplicationContext(), "Item uploaded successfully", Toast.LENGTH_SHORT).show();
//                }).addOnFailureListener(fail -> {
//                    Toast.makeText(getApplicationContext(), "Item upload unsuccessful", Toast.LENGTH_SHORT).show();
//                });


    
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.uploadItemCat);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itemCatArray, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }


    public void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: starts");
        FusedLocationProviderClient mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{

                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "getDeviceLocation: onComplete: found location");
                            Location currentLocation = (Location) task.getResult();
                            if(currentLocation != null) {
                                String itemName = mItemName.getText().toString().trim();
                                String itemDescription = mItemDescription.getText().toString().trim();
                                int itemValue = Integer.parseInt(mItemValue.getText().toString().trim());
                                String itemCategory = mItemCat.getSelectedItem().toString().trim();

                                Item item = new Item(itemName, itemDescription, itemCategory, itemValue, currentLocation.getLatitude(), currentLocation.getLongitude());
                                DatabaseItem db = new DatabaseItem();
                                db.addItem(item).addOnSuccessListener(success -> {
                                    Toast.makeText(getApplicationContext(), "Item uploaded successfully", Toast.LENGTH_SHORT).show();
                                }).addOnFailureListener(fail -> {
                                    Toast.makeText(getApplicationContext(), "Item upload unsuccessful", Toast.LENGTH_SHORT).show();
                                });
                                Log.d(TAG, "getDeviceLocation: currentLocation Latitude: " + currentLocation.getLatitude());
                                Log.d(TAG, "getDeviceLocation: currentLocation Longitude: " + currentLocation.getLongitude());
                            }else
                                Log.d(TAG, "getDeviceLocation: Current location is null");
                        }else {
                            Log.d(TAG, "getDeviceLocation: Current location is null");
                        }
                    }
                });

        }catch (SecurityException se){
            Log.d(TAG, "getDeviceLocation: SecurityException: =" + se.getMessage());
        }
        Log.d(TAG, "getDeviceLocation: ends");
    }
//    private Double [] getCurrentLocation() {
//        Double location [] = new Double[2];
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(UploadItems.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//
//                if (isGPSEnabled()) {
//
//                    LocationServices.getFusedLocationProviderClient(UploadItems.this)
//                            .requestLocationUpdates(locationRequest, new LocationCallback() {
//
//                                @Override
//                                public void onLocationResult(@NonNull LocationResult locationResult) {
//                                    super.onLocationResult(locationResult);
//
//                                    LocationServices.getFusedLocationProviderClient(UploadItems.this)
//                                            .removeLocationUpdates(this);
//
//                                    if (locationResult != null && locationResult.getLocations().size() >0){
//
//                                        int index = locationResult.getLocations().size() - 1;
//                                        Log.d(TAG, "getDeviceLocation: "+index);
//                                        double latitude = locationResult.getLocations().get(index).getLatitude();
//                                        double longitude = locationResult.getLocations().get(index).getLongitude();
//                                        System.out.println(locationResult);
//
//                                        location[0] = longitude;
//                                        location[1] = latitude;
//
//
//                                    }
//                                }
//                            }, Looper.getMainLooper());
//
//                } else {
//                    turnOnGPS();
//                }
//
//            } else {
//                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//            }
//        }
//        return location;
//    }
//
//    private void turnOnGPS() {
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(locationRequest);
//        builder.setAlwaysShow(true);
//
//        Task<LocationSettingsResponse> result = LocationServices.getSettingsClient(getApplicationContext())
//                .checkLocationSettings(builder.build());
//
//        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
//            @Override
//            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
//
//                try {
//                    LocationSettingsResponse response = task.getResult(ApiException.class);
//                    Toast.makeText(UploadItems.this, "GPS is already turned on", Toast.LENGTH_SHORT).show();
//
//                } catch (ApiException e) {
//
//                    switch (e.getStatusCode()) {
//                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//
//                            try {
//                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
//                                resolvableApiException.startResolutionForResult(UploadItems.this, 2);
//                            } catch (IntentSender.SendIntentException ex) {
//                                ex.printStackTrace();
//                            }
//                            break;
//
//                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                            //Device does not have location
//                            break;
//                    }
//                }
//            }
//        });
//    }
//
//    private boolean isGPSEnabled() {
//        LocationManager locationManager = null;
//        boolean isEnabled = false;
//
//        if (locationManager == null) {
//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        }
//
//        isEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        return isEnabled;
//    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }




}