package com.ragequit.lolmatchup.io.responses;

import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.ragequit.lolmatchup.io.RequestUtil;
import com.ragequit.lolmatchup.vo.MatchSummary;
import com.ragequit.lolmatchup.vo.Participant;
import com.ragequit.lolmatchup.vo.ParticipantIdentity;
import com.ragequit.lolmatchup.vo.ParticipantWrapper;

import java.util.ArrayList;

/**
 * Created by jamnoran on 4/13/15.
 */
public class GetCurrentGame {


    private static final String TAG = GetCurrentGame.class.getSimpleName();

    @SerializedName("gameId")
    public long gameId;
    @SerializedName("gameMode")
    public String gameMode;
    @SerializedName("gameType")
    public String gameType;
    @SerializedName("mapId")
    public long mapId;
    @SerializedName("participants")
    public ArrayList<Participant> participants;


    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public static String getURL(long summonerId){
        String url = "https://" + RequestUtil.getServer() + ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/" + RequestUtil.getServerPlatform() + "/" + summonerId + "?" + RequestUtil.getKeyParameter();
        Log.i(TAG, "URL: " + url);
        return url;
    }

    @Override
    public String toString() {
        return "GetCurrentGame{" +
                "gameId=" + gameId +
                ", gameMode='" + gameMode + '\'' +
                ", gameType='" + gameType + '\'' +
                ", mapId=" + mapId +
                ", participants=" + participants +
                '}';
    }

}
