package com.example.yogg_sogott.sunnetwork.data;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkService {
    private static final String URL = "https://my-json-server.typicode.com/yogg-soggot/SunNetwork/";
    private Retrofit mRetrofit;

    //Dagger2
    @Inject
    public NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public JSONPlaceHolderApi getJSONApi(){
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
}
