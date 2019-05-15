package com.example.litho.picasso;

import com.facebook.soloader.SoLoader;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SoLoader.init(this, false);
    }
}
