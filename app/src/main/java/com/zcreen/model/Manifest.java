package com.zcreen.model;

import com.google.gson.annotations.SerializedName;
import com.orhanobut.hawk.Hawk;

import java.util.List;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public class Manifest {

    private static final String KEY_MANIFEST = "carbon_seamless_manifest";

    private int code;
    private String message;

    @SerializedName("data")
    private List<TvGuide> tvGuideList;

    public static void save(Manifest manifest) {
        Hawk.put(KEY_MANIFEST, manifest);
    }

    public static Manifest get() {
        return Hawk.get(KEY_MANIFEST);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<TvGuide> getTvGuideList() {
        return tvGuideList;
    }

    @Override
    public String toString() {
        return "Manifest{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", tvGuideList=" + tvGuideList +
                '}';
    }
}
