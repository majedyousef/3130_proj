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
import com.google.firebase.database.DataSnapshot;

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
                            double lat = currentLocation.getLatitude();
                            double longi = currentLocation.getLongitude();

                            Item item = new Item(itemName, itemDescription, itemCategory, itemValue, lat, longi);
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
                        Log.d(TAG, "getDeviceLocation: Task was not successful");
                    }
                }
            });
        }catch (SecurityException se){
            Log.d(TAG, "getDeviceLocation: SecurityException: =" + se.getMessage());
        }
        Log.d(TAG, "getDeviceLocation: ends");
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}