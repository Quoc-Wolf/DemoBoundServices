package com.example.quocnp.demoboundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {

    private final IBinder iBinder = new LocalBinder();

    private final Random mGenerator = new Random();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int getRandom() {
        return mGenerator.nextInt(100);
    }

    public class LocalBinder extends Binder {
        MyService getServices() {
            return MyService.this;
        }
    }
}
