package com.ragequit.lolmatchup.io.responses;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ragequit.lolmatchup.io.RequestUtil;
import com.ragequit.lolmatchup.vo.Request;
import com.ragequit.lolmatchup.vo.Summoner;

import java.util.Map;

/**
 * Created by jamnoran on 4/13/15.
 */
public class GetSummoner {

    private static final String TAG = GetSummoner.class.getSimpleName();
    public Map<String, Summoner> summoners = null;

    public GetSummoner() {
       
    }

    public Summoner summonerName(String summonerName) {
        String url = "https://" + RequestUtil.getServer() + ".api.pvp.net/api/lol/" + RequestUtil.getServer() + "/v1.4/summoner/by-name/" + summonerName + "?" + RequestUtil.getKeyParameter();
        Log.i(TAG, "URL: " + url);
        Map<String, Summoner> summoners = null;
        try {
            String responseString = Request.execute(url);
            summoners = new Gson().fromJson(responseString, new TypeToken<Map<String, Summoner>>() {}.getType());
        } catch (JsonSyntaxException e) {
            Log.i(TAG, "Exception : " + e);
        }
        Summoner summoner = null;
        if (summonerName != null && !summonerName.equals("")) {
            try {
                summoner = summoners.get(summonerName.toLowerCase());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return summoner;
    }
}