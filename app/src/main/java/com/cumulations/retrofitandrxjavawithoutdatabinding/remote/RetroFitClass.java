package com.cumulations.retrofitandrxjavawithoutdatabinding.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClass {

    private static String BASEURL = "https://api.myjson.com/bins/";

    private static Retrofit getRetrofitinstance() {
        return new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static APICALL getAPIinstance() {
        return getRetrofitinstance().create(APICALL.class);
    }
}
