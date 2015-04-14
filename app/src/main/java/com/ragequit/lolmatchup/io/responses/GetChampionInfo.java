package com.ragequit.lolmatchup.io.responses;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ragequit.lolmatchup.io.RequestUtil;
import com.ragequit.lolmatchup.vo.ImageObject;
import com.ragequit.lolmatchup.vo.Request;
import com.ragequit.lolmatchup.vo.Summoner;

import java.util.Map;

/**
 * Created by jamnoran on 4/13/15.
 */
public class GetChampionInfo {

    private static final String TAG = GetChampionInfo.class.getSimpleName();

    @SerializedName("id")
    public int id = 0;
    @SerializedName("name")
    public String name = null;
    @SerializedName("title")
    public String title = null;
    @SerializedName("image")
    public ImageObject image = null;


    public GetChampionInfo() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageObject getImage() {
        return image;
    }

    public void setImage(ImageObject image) {
        this.image = image;
    }

    public static String getURL(long championId){
        String url = "https://global.api.pvp.net/api/lol/static-data/" + RequestUtil.getServer() + "/v1.2/champion/" + championId + "?champData=image&" + RequestUtil.getKeyParameter();
        Log.i(TAG, "URL: " + url);
        return url;
    }

    @Override
    public String toString() {
        return "GetChampionInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}