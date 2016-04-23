package com.zcreen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zcreen.R;
import com.zcreen.core.ZcreenApp;
import com.zcreen.event.SplashFinishEvent;
import com.zcreen.model.Manifest;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mertkanuzunparmak on 15/03/16.
 * mertkan@mobilike.com
 */
public class SplashActivity extends Activity {

    private final Handler splashHandler = new Handler();
    private final Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {

            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);

            EventBus.getDefault().postSticky(new SplashFinishEvent());
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        fetchShowManifest();
    }

    @Override
    protected void onStart() {
        super.onStart();
        splashHandler.postDelayed(
                splashRunnable,
                TimeUnit.SECONDS.toMillis(3)
        );
    }

    @Override
    protected void onStop() {
        splashHandler.removeCallbacks(splashRunnable);
        super.onStop();
    }

    private void fetchShowManifest() {
        ZcreenApp.getInstance().getNetworkManager().getManifestApi().getManifest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(manifestSubscriber());
    }

    private Subscriber<Manifest> manifestSubscriber() {
        return new Subscriber<Manifest>() {
            @Override
            public void onCompleted() {
                // no-op
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Manifest manifest) {
                Manifest.save(manifest);
            }
        };
    }
}
