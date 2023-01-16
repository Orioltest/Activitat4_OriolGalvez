package com.example.activitat4_oriolgalvez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://chat.socket.io");
        } catch (URISyntaxException e) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSocket.connect();
    }
}