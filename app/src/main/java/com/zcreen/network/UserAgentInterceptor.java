package com.zcreen.network;

import android.content.Context;
import android.os.Build;

import com.zcreen.Zcreen;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public final class UserAgentInterceptor implements Interceptor {

    private final String userAgent;

    public UserAgentInterceptor(Context context) {
        this.userAgent = createUserAgentString(context);
    }

    private String createUserAgentString(Context context) {
        // TODO: Add device name, probably using context
        return String.format(Locale.getDefault(),
                "Zcreen/%s (%s; Android %d)", Zcreen.APP_VERSION, "DeviceName", Build.VERSION.SDK_INT);
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .header(Http.Header.Field.USER_AGENT, userAgent)
                .build();
        return chain.proceed(request);
    }
}
