package com.ragequit.lolmatchup.vo;

import android.provider.Telephony;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jamnoran on 4/13/15.
 */
public class MatchSummary {


    @SerializedName("mapId")
    public int mapId;
    @SerializedName("matchCreation")
    public long matchCreation;
    @SerializedName("matchDuration")
    public long matchDuration;
    @SerializedName("matchId")
    public long matchId;
    @SerializedName("matchMode")
    public String matchMode;
    @SerializedName("matchType")
    public String matchType;
    @SerializedName("matchVersion")
    public String matchVersion;
    @SerializedName("platformId")
    public String platformId;
    @SerializedName("queueType")
    public String queueType;
    @SerializedName("region")
    public String region;
    @SerializedName("season")
    public String season;
    @SerializedName("participants")
    public ArrayList<Participant> participants;
    @SerializedName("participantIdentities")
    public ArrayList<ParticipantIdentity> participantIdentities;

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public long getMatchCreation() {
        return matchCreation;
    }

    public void setMatchCreation(long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public long getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration(long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public void setMatchVersion(String matchVersion) {
        this.matchVersion = matchVersion;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public ArrayList<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(ArrayList<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

    @Override
    public String toString() {
        return "MatchSummary{" +
                "mapId=" + mapId +
                ", matchCreation=" + matchCreation +
                ", matchDuration=" + matchDuration +
                ", matchId=" + matchId +
                ", participants=" + participants +
                ", participantIdentities=" + participantIdentities +
                ", matchMode='" + matchMode + '\'' +
                ", matchType='" + matchType + '\'' +
                ", matchVersion='" + matchVersion + '\'' +
                ", platformId='" + platformId + '\'' +
                ", queueType='" + queueType + '\'' +
                ", region='" + region + '\'' +
                ", season='" + season + '\'' +
                '}';
    }

    public String getParticipantName(int participantId) {
        for(ParticipantIdentity participant : getParticipantIdentities()){
            if(participant.getParticipantId() == participantId){
                return participant.getPlayer();
            }
        }
        return null;
    }
}
