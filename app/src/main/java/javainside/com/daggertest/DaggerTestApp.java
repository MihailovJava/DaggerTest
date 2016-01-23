package javainside.com.daggertest;


import android.app.Application;
import android.content.Context;

import javainside.com.daggertest.di.DaggerIDaggerTestComponent;
import javainside.com.daggertest.di.DaggerTestImageModelModule;
import javainside.com.daggertest.di.DaggerTestSpeakerModule;
import javainside.com.daggertest.di.IDaggerTestComponent;


public class DaggerTestApp extends Application{
    IDaggerTestComponent component;


    public static IDaggerTestComponent component(Context context){
        return ((DaggerTestApp) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerIDaggerTestComponent
                .builder()
                .daggerTestImageModelModule(new DaggerTestImageModelModule())
                .daggerTestSpeakerModule(new DaggerTestSpeakerModule())
                .build();
    }
}
