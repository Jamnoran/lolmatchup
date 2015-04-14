package com.ragequit.lolmatchup.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jamnoran on 4/13/15.
 */
public class Summoner {

    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("profileIconId")
    public int profileIconId;
    @SerializedName("revisionDate")
    public long revisionDate;
    @SerializedName("summonerLevel")
    public long summonerLevel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }


    @Override
    public String toString() {
        return "Summoner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profileIconId=" + profileIconId +
                ", revisionDate=" + revisionDate +
                ", summonerLevel=" + summonerLevel +
                '}';
    }
}
