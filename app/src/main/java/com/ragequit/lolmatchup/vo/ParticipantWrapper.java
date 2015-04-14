package com.ragequit.lolmatchup.vo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ragequit.lolmatchup.R;
import com.ragequit.lolmatchup.io.responses.GetChampionInfo;
import com.squareup.picasso.Picasso;

import java.net.URLEncoder;

/**
 * Created by jamnoran on 4/13/15.
 */
public class ParticipantWrapper {
    private static final String TAG = ParticipantWrapper.class.getSimpleName();
    private Context context = null;

    @SerializedName("participant")
    public Participant participant;

    private RelativeLayout layout;


    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public void setLayout(RelativeLayout layout) {
        this.layout = layout;
    }

    public RelativeLayout getLayout() {
        return layout;
    }

    public void getChampionLogo(Context context) {
        this.context = context;
        Log.i(TAG, "Get champion logo");
        new GetChampionOperation().execute("");
    }



    public class GetChampionOperation extends AsyncTask<String, Void, String> {
        GetChampionInfo response;
        @Override
        protected String doInBackground(String... params) {

            // Champion image url :  http://ddragon.leagueoflegends.com/cdn/4.2.6/img/champion/Aatrox.png
            //https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/25?api_key=f17c2f81-75c2-4609-b119-3399e8426ba8

            Gson gson = new Gson();
            String responseString = Request.execute(GetChampionInfo.getURL(participant.getChampionId()));
            response = gson.fromJson(responseString, GetChampionInfo.class);
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            if (response != null && context != null) {
                Log.i(TAG, "Got this response " + response.toString());
                if(response.name != null){
                    try {
                        ImageView championLogo = (ImageView) getLayout().findViewById(R.id.champion_logo);
                        Log.i(TAG, "Setting image to : " + "http://ddragon.leagueoflegends.com/cdn/5.7.2/img/champion/" + URLEncoder.encode(response.getImage().getFull(), "UTF-8"));
                        Picasso.with(context).load("http://ddragon.leagueoflegends.com/cdn/5.7.2/img/champion/" + URLEncoder.encode(response.getImage().getFull(), "UTF-8")).into(championLogo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
