package gsp.com.dimensionbusiness.ui.fragment;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class Banner extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
