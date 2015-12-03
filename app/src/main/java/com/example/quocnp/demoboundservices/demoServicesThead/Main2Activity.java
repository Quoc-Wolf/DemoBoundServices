package com.example.quocnp.demoboundservices.demoServicesThead;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quocnp.demoboundservices.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void startServices(View view) {
        Intent intent = new Intent(this, MyServiceThead.class);
        startService(intent);
    }

    public void stopServices(View view) {
        Intent intent = new Intent(this, MyServiceThead.class);
        stopService(intent);
    }
}
