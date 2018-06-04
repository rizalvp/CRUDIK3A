package id.rizalprasetya.crudik3a.network;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rizal Prasetya on 28/05/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.241:8080/Laravel/Laravel52/public/"; //alamat dasar API

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;
    }

}
