package com.zyyoona7.jokes.model.service;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class JokeService {

    private static volatile JokesApi mJokesApi;
    private static OkHttpClient mOkHttpClient = new OkHttpClient();
    private static GsonConverterFactory mGsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory mRxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private JokeService() {

    }

    /**
     * 单例获取JokesApi
     *
     * @return
     */
    public static JokesApi getJokesApi() {
        if (mJokesApi == null) {
            synchronized (JokeService.class) {
                if (mJokesApi == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://japi.juhe.cn/joke/")
                            .client(mOkHttpClient)
                            .addCallAdapterFactory(mRxJavaCallAdapterFactory)
                            .addConverterFactory(mGsonConverterFactory)
                            .build();
                    mJokesApi = retrofit.create(JokesApi.class);
                }
            }
        }
        return mJokesApi;
    }
}
