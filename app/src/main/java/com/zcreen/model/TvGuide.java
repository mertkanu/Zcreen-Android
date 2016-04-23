package com.zcreen.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mertkanuzunparmak on 22/03/16.
 * mertkan@mobilike.com
 */
public class TvGuide {

    private String showName;
    private String type;
    private String channel;
    private String airTime;
    private List<String> airDays;

    @SerializedName("imageURL")
    private String imageUrl;
    private String description;

    public String getShowName() {
        return showName;
    }

    public String getType() {
        return type;
    }

    public String getChannel() {
        return channel;
    }

    public String getAirTime() {
        return airTime;
    }

    public List<String> getAirDays() {
        return airDays;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "TvGuide{" +
                "showName='" + showName + '\'' +
                ", type='" + type + '\'' +
                ", channel='" + channel + '\'' +
                ", airTime='" + airTime + '\'' +
                ", airDays=" + airDays +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
