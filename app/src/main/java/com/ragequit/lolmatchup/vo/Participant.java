package com.ragequit.lolmatchup.vo;

import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ragequit.lolmatchup.R;
import com.ragequit.lolmatchup.io.responses.GetChampionInfo;
import com.ragequit.lolmatchup.io.responses.GetCurrentGame;
import com.ragequit.lolmatchup.io.responses.GetSummoner;
import com.squareup.picasso.Picasso;

/**
 * Created by jamnoran on 4/13/15.
 */
public class Participant {
    private static final String TAG = Participant.class.getSimpleName();
    private Context context = null;
    @SerializedName("championId")
    public int championId;
    @SerializedName("participantId")
    public int participantId;
    @SerializedName("highestAchievedSeasonTier")
    public String highestAchievedSeasonTier;
    @SerializedName("summonerName")
    public String summonerName;
    @SerializedName("spell1Id")
    public int spell1Id;
    @SerializedName("spell2Id")
    public int spell2Id;
    @SerializedName("teamId")
    public int teamId;

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public int getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(int spell1Id) {
        this.spell1Id = spell1Id;
    }

    public int getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(int spell2Id) {
        this.spell2Id = spell2Id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "championId=" + championId +
                ", highestAchievedSeasonTier='" + highestAchievedSeasonTier + '\'' +
                ", spell1Id=" + spell1Id +
                ", spell2Id=" + spell2Id +
                ", summonerName=" + summonerName +
                ", participantId=" + participantId +
                ", teamId=" + teamId +
                '}';
    }
}
