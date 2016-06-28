package com.zyyoona7.jokes.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public class JokesApp extends Application{

    private Context mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public Context getInstance(){
        return mInstance;
    }
}
