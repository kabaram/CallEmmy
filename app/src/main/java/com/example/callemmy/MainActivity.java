package com.example.callemmy;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.ConnectionService;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConnectionService service;
    TextView bottomStatus;
    TelecomManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callClick(View view) {
        service = new MyConnectionService();
        bottomStatus = (TextView) findViewById(R.id.statusText);
        String msg = "Trying to call Emmy...";
        bottomStatus.setText(msg);
        System.out.println("Trying to call");

        //Access phone app on device
        manager = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);

        // Check if app has permission to access phone privileges
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            String[] permissions = {Manifest.permission.CALL_PHONE};
            int requestCode = 0;
            ActivityCompat.requestPermissions(this, permissions,  requestCode);
            System.out.println("need permission");
        }
        Bundle extras = new Bundle();

        try {
            // Enter phone app and place call
            // TODO: modify placeCall to desired phone number
            manager.placeCall(Uri.parse("tel:(+1)5555555555"), extras);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Made call");
    }
}