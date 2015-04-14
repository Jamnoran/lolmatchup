package com.ragequit.lolmatchup.io.responses;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ragequit.lolmatchup.io.RequestUtil;
import com.ragequit.lolmatchup.vo.MatchSummary;
import com.ragequit.lolmatchup.vo.Request;
import com.ragequit.lolmatchup.vo.Summoner;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jamnoran on 4/13/15.
 */
public class GetMatchHistory {


    private static final String TAG = GetMatchHistory.class.getSimpleName();

    @SerializedName("matches")
    ArrayList<MatchSummary> matches;

    public ArrayList<MatchSummary> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<MatchSummary> matches) {
        this.matches = matches;
    }

    public static String getURL(long summonerId){
        String url = "https://" + RequestUtil.getServer() + ".api.pvp.net/api/lol/" + RequestUtil.getServer() + "/v2.2/matchhistory/" + summonerId + "?" + RequestUtil.getKeyParameter();
        Log.i(TAG, "URL: " + url);
        return url;
    }

    @Override
    public String toString() {
        return "GetMatchHistory{" +
                "matches=" + matches +
                '}';
    }
}
