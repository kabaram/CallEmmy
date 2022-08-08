package com.example.callemmy;

import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;
import android.widget.Toast;

public class MyConnectionService  extends ConnectionService {
    Connection connection;

    @Override
    public Connection onCreateOutgoingConnection(PhoneAccountHandle pah, ConnectionRequest cr){
        connection = new MyConnection();
        return connection;
    }

    @Override
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle pah, ConnectionRequest cr){
        Toast connectFail = Toast.makeText(this, "Connection Failed", Toast.LENGTH_SHORT);
        connectFail.show();
    }

}
