package com.ragequit.lolmatchup.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.ragequit.lolmatchup.MainActivity;
import com.ragequit.lolmatchup.R;
import com.ragequit.lolmatchup.screens.templates.Screen;

/**
 * Created by jamnoran on 4/14/15.
 */
public class MethodManager {
    private static MainActivity instance;
    private static Screen currentScreen;

    public static MainActivity getInstance() {
        return instance;
    }

    public static void setInstance(MainActivity setInstance) {
        instance = setInstance;
    }

    public static void startScreen(Screen screenToStart){
        currentScreen = screenToStart;
        screenToStart.init();
    }

    public static void setLayout(View view) {
        LinearLayout layout = (LinearLayout) instance.findViewById(R.id.main_layout);
        layout.removeAllViews();
        layout.addView(view);
    }


    public static void hideVirturalKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) instance.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(instance.getWindow().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // May not always be able to hide it.
        }
    }
}
