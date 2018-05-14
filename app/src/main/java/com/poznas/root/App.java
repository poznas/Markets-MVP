package com.poznas.root;

import android.app.Application;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
