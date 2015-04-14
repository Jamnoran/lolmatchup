package com.ragequit.lolmatchup.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jamnoran on 4/14/15.
 */
public class ImageObject {

    @SerializedName("full")
    public String full = null;
    @SerializedName("sprite")
    public String sprite = null;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "ImageObject{" +
                "full='" + full + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
