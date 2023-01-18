package com.example.activitat4_oriolgalvez;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    private Socket mSocket;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto= findViewById(R.id.num);
        try {
            mSocket = IO.socket("http://a21origalgom.alumnes.inspedralbes.cat:7085/");
        } catch (URISyntaxException e) {}
        mSocket.connect();
        mSocket.on("chat message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                String msg = args[0].toString();
                runOnUiThread(() -> {
                    texto.setText(msg);
                });
            }
        });
    }
}