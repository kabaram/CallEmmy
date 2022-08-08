package com.example.callemmy;

import androidx.annotation.RequiresApi;

import android.telecom.Connection;

import static android.telecom.TelecomManager.PRESENTATION_ALLOWED;

public class MyConnection extends Connection {

    public MyConnection() {
        //setConnectionProperties(PROPERTY_SELF_MANAGED);
        setCallerDisplayName("Eric", PRESENTATION_ALLOWED);
    }
/*
    @Override
    public void onShowIncomingCallUi(){

    }

    @Override
    public void onCallAudioStateChanged(CallAudioState cas){

    }

    @Override
    public void onHold(){

    }

    @Override
    public void onUnhold(){

    }

    @Override
    public void onAnswer(){

    }

    @Override
    public void onReject(){

    }

    @Override
    public void onDisconnect(){

    } */
}
