package com.example.rxjavademo.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRemote {

    protected <T> T create(Class<T> tClass, String baseUrl) {
        return getRetrofitInstance(baseUrl).create(tClass);
    }

    private Retrofit getRetrofitInstance(String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
