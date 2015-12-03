package com.example.quocnp.demoboundservices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quocnp.demoboundservices.demoServicesThead.Main2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyService myService;
    boolean isBound = false;
    private Button mBtnMoveDemoServices2;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            myService = binder.getServices();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        mBtnMoveDemoServices2 = (Button) findViewById(R.id.btnSwitchDemo2);
        mBtnMoveDemoServices2.setOnClickListener(this);
    }

    public void getRandomNumber(View view) {
        TextView tvShow = (TextView) findViewById(R.id.tvShow);
        tvShow.setText(Integer.toString(myService.getRandom()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSwitchDemo2:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
        }
    }
}
