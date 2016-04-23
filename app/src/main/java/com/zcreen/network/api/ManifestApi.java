package com.zcreen.network.api;

import com.zcreen.model.Manifest;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public interface ManifestApi {

    @GET("dummymanifest2/subsizemma.json")
    Observable<Manifest> getManifest();
}
