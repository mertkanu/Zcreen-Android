package com.zcreen.core;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.zcreen.network.NetworkManager;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public class ZcreenApp extends Application {

    private static ZcreenApp instance;

    private NetworkManager networkManager;

    public static ZcreenApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initHawk();
    }

    private void initHawk() {
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.NO_ENCRYPTION)
                .build();
    }

    public NetworkManager getNetworkManager() {
        if (networkManager == null) {
            networkManager = new NetworkManager(this);
        }

        return networkManager;
    }
}
