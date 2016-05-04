package com.zcreen.utility;

import android.os.Build;
import android.text.TextUtils;

import com.zcreen.Zcreen;

/**
 * Created by mertkanuzunparmak on 23/02/16.
 * mertkan@mobilike.
 * @deprecated Using {@link com.zcreen.network.UserAgentInterceptor} class
 */
public class HttpUtilities {

    private static HttpUtilities sharedInstance = null;
    private static String userAgent = null;

    public static synchronized HttpUtilities sharedInstance() {

        if (sharedInstance == null) {
            sharedInstance = new HttpUtilities();
        }

        return sharedInstance;
    }

    public synchronized String getUserAgent() {

        if (TextUtils.isEmpty(userAgent)) {

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("ZcreenApp")
                    .append("/")
                    .append(Zcreen.APP_VERSION)
                    .append(" (")
                    .append("Android ")
                    .append(Build.VERSION.SDK_INT)
                    .append(")");

            userAgent = stringBuilder.toString();
        }

        return userAgent;
    }
}
