package com.zcreen.network;

import android.content.Context;

import com.zcreen.network.api.ManifestApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mertkanuzunparmak on 23/02/16.
 * mertkan@mobilike.com
 */
public class NetworkManager {

    // TODO Kerem & Saygın. Buradan sizin apilere çekebilirsiniz.
    private final String BASE_URL = "http://ad.mobilike.com/";

    private final ManifestApi manifestApi;

    public NetworkManager(Context context) {
        OkHttpClient client = createOkHttpClient(context);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        manifestApi = retrofit.create(ManifestApi.class);

    }

    protected OkHttpClient createOkHttpClient(Context context) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new UserAgentInterceptor(context))
                .build();
    }

    public ManifestApi getManifestApi() {
        return manifestApi;
    }
}
