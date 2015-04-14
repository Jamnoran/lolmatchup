package com.ragequit.lolmatchup.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jamnoran on 4/13/15.
 */
public class ParticipantIdentity {

    @SerializedName("participantId")
    public int participantId;
    @SerializedName("player")
    public String player;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "ParticipantIdentity{" +
                "participantId=" + participantId +
                ", player='" + player + '\'' +
                '}';
    }
}
