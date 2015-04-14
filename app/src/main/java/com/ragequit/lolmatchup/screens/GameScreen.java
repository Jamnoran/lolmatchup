package com.ragequit.lolmatchup.screens;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ragequit.lolmatchup.R;
import com.ragequit.lolmatchup.io.responses.GetCurrentGame;
import com.ragequit.lolmatchup.io.responses.GetSummoner;
import com.ragequit.lolmatchup.screens.templates.Screen;
import com.ragequit.lolmatchup.util.MethodManager;
import com.ragequit.lolmatchup.vo.Participant;
import com.ragequit.lolmatchup.vo.ParticipantWrapper;
import com.ragequit.lolmatchup.vo.Request;
import com.ragequit.lolmatchup.vo.Summoner;

import java.util.ArrayList;

/**
 * Created by jamnoran on 4/14/15.
 */
public class GameScreen extends Screen{
    private static final String TAG = GameScreen.class.getSimpleName();

    private GetCurrentGame response;

    private LinearLayout layoutForGame;

    public GameScreen() {
    }

    public void init(){
        layoutForGame = new LinearLayout(MethodManager.getInstance());
        layoutForGame.setOrientation(LinearLayout.VERTICAL);
        new GetSummonerOperation().execute("");
    }



    public class GetSummonerOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            SharedPreferences settings = MethodManager.getInstance().getSharedPreferences(MethodManager.getInstance().getString(R.string.app_name), 0);
            String summonerName = settings.getString("SUMMONER", null);
            Summoner summoner = new GetSummoner().summonerName(summonerName);
            Log.i(TAG, "Got summoner: " + summoner);

            if (summoner != null) {
                Gson gson = new Gson();
                String responseString = Request.execute(GetCurrentGame.getURL(summoner.getId()));
                if (responseString != null && !responseString.equals("")) {
                    response = gson.fromJson(responseString, GetCurrentGame.class);
                }
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            if (response != null) {
                Log.i(TAG, "Game: " + response.toString());
                showGame(response);
            }else {
                showError("Player is not in any active games");
            }
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    private void showError(String error) {
        TextView errorMessage = new TextView(MethodManager.getInstance());
        errorMessage.setText(error);
        errorMessage.setTextColor(Color.BLACK);
        errorMessage.setPadding(20, 20, 20, 20);
        errorMessage.setTextSize(20);
        MethodManager.setLayout(errorMessage);
    }


    private void showGame(GetCurrentGame history) {
        ArrayList<ParticipantWrapper> participantsWrappers = createWrappers(history.getParticipants());
        Log.i(TAG, "Got game, time to show layouts for it");
        for (ParticipantWrapper participant : participantsWrappers) {
            RelativeLayout summonerLayout = (RelativeLayout) MethodManager.getInstance().getLayoutInflater().inflate(R.layout.summoner_layout, null);
            TextView champions = (TextView) summonerLayout.findViewById(R.id.summoner_name);
            TextView description = (TextView) summonerLayout.findViewById(R.id.description);
            String summonerName = participant.getParticipant().getSummonerName();
            champions.setText(summonerName);
//            description.setText("");
            if (participant.getParticipant().getTeamId() == 100){
                champions.setTextColor(Color.RED);
            }else if (participant.getParticipant().getTeamId() == 200){
                champions.setTextColor(Color.BLUE);
            }

            // SummonerSpell 1
            ImageView ss1 = (ImageView) summonerLayout.findViewById(R.id.spell1);
            ss1.setImageResource(getSummonerSpellById(participant.getParticipant().getSpell1Id()));
            // SummonerSpell 2
            ImageView ss2 = (ImageView) summonerLayout.findViewById(R.id.spell2);
            ss2.setImageResource(getSummonerSpellById(participant.getParticipant().getSpell2Id()));

            participant.setLayout(summonerLayout);

            Log.i(TAG, "Setting layout, and trying to find image for it.");

            participant.getChampionLogo(MethodManager.getInstance());
            layoutForGame.addView(summonerLayout);
        }
        MethodManager.setLayout(layoutForGame);
    }

    private int getSummonerSpellById(int spellId) {
        switch (spellId) {
            case 4:
                return R.drawable.flash;
            case 14:
                return R.drawable.ignite;
            case 7:
                return R.drawable.heal;
            case 12:
                return R.drawable.teleport;
            case 11:
                return R.drawable.smite;
            case 6:
                return R.drawable.ghost;
            case 3:
                return R.drawable.exhaust;
            default:
                break;
        }

        return 0;
    }

    public ArrayList<ParticipantWrapper> createWrappers(ArrayList<Participant> participants) {
        ArrayList<ParticipantWrapper> participantsWrappers = new ArrayList<>();
        for(Participant participant : participants){
            ParticipantWrapper wrapper = new ParticipantWrapper();
            wrapper.setParticipant(participant);
            participantsWrappers.add(wrapper);
        }
        return participantsWrappers;
    }

}
