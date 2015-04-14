package com.ragequit.lolmatchup.screens;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.ragequit.lolmatchup.R;
import com.ragequit.lolmatchup.screens.templates.Screen;
import com.ragequit.lolmatchup.util.MethodManager;

/**
 * Created by jamnoran on 4/14/15.
 */
public class SettingScreen extends Screen {

    public SettingScreen() {
    }

    public void init(){

        showInputs();

    }

    private void showInputs() {
        final RelativeLayout summonerLayout = (RelativeLayout) MethodManager.getInstance().getLayoutInflater().inflate(R.layout.summoner_input, null);
//        Spinner spinner = (Spinner) summonerLayout.findViewById(R.id.spinner);
        final EditText summonerInput = (EditText) summonerLayout.findViewById(R.id.summoner_name_input);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MethodManager.getInstance(), R.array.realm_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        SharedPreferences settings = MethodManager.getInstance().getSharedPreferences(MethodManager.getInstance().getString(R.string.app_name), 0);
        String summoner = settings.getString("SUMMONER", null);
        summonerInput.setText(summoner);


        Button findGameButton = (Button) summonerLayout.findViewById(R.id.find_game);
        findGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences settings = MethodManager.getInstance().getSharedPreferences(MethodManager.getInstance().getString(R.string.app_name), 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("SUMMONER", summonerInput.getText().toString());
                editor.commit();

                MethodManager.hideVirturalKeyboard();
                MethodManager.startScreen(new GameScreen());
            }
        });

        MethodManager.setLayout(summonerLayout);
    }


    private void showError(String error) {
        TextView errorMessage = new TextView(MethodManager.getInstance());
        errorMessage.setText(error);
        errorMessage.setTextColor(Color.BLACK);
        errorMessage.setPadding(20, 20, 20, 20);
        errorMessage.setTextSize(20);
        MethodManager.setLayout(errorMessage);
    }
}
