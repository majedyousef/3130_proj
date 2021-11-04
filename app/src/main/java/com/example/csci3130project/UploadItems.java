package com.example.csci3130project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;

public class UploadItems extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText mItemName, mItemDescription;
    EditText mItemValue;
    Spinner mItemCat;
    Button mButton;
    Double longitudeHolder;
    Double latitudeHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_items);
        mItemName = (EditText) findViewById(R.id.uploadItemName);
        mItemValue = (EditText) findViewById(R.id.uploadItemValue);
        mItemDescription = (EditText) findViewById(R.id.uploadItemdesc);
        mButton = (Button) findViewById(R.id.uploadBtn);
        mItemCat = (Spinner) findViewById(R.id.uploadItemCat);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = mItemName.getText().toString().trim();
                String itemDescription = mItemDescription.getText().toString().trim();
                int itemValue = Integer.parseInt(mItemValue.getText().toString().trim());
                String itemCategory = mItemCat.getSelectedItem().toString().trim();
                getDeviceLocation();
                Item item = new Item(itemName, itemDescription, itemCategory, itemValue,longitudeHolder,latitudeHolder);
                DatabaseItem db = new DatabaseItem();
                db.addItem(item).addOnSuccessListener(success -> {
                    Toast.makeText(getApplicationContext(), "Item uploaded successfully", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(fail -> {
                    Toast.makeText(getApplicationContext(), "Item upload unsuccessful", Toast.LENGTH_SHORT).show();
                });


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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void getDeviceLocation() {
        FusedLocationProviderClient mFusedLocationProviderClient;
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Task location = mFusedLocationProviderClient.getLastLocation();
        location.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    Log.d("upload", "getDeviceLocation: onComplete: found location");
                    Location currentLocation = (Location) task.getResult();
                    if (currentLocation != null) {
                        // change these two lines to set the lat and long in the item object when you set it
                        Log.d("upload", "getDeviceLocation: currentLocation Lattitude: " + currentLocation.getLatitude());
                        Log.d("upload", "getDeviceLocation: currentLocation Longitude: " + currentLocation.getLongitude());
                        longitudeHolder = currentLocation.getLongitude();
                        latitudeHolder = currentLocation.getLatitude();
                    }
                    // if the location is null then do something
                    else {
                        Log.d("upload", "getDeviceLocation: Current location is null");
                    }
                }
                // if we cant find the device location do somnething else, change to whatever you like
                else {
                    Log.d("upload", "getDeviceLocation: Current location is null");
                    Toast.makeText(UploadItems.this, "Unable to get curent location", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


}