package com.ragequit.lolmatchup.io;

import com.ragequit.lolmatchup.util.Configuration;

/**
 * Created by jamnoran on 4/13/15.
 */
public class RequestUtil {

    private static String server = "euw";
    private static String serverPlatform = "EUW1";

    public static String getKeyParameter(){
        return "api_key=" + Configuration.API_KEY;
    }

    public static String getServer(){
        return server;
    }

    public static String getServerPlatform() {
        return serverPlatform;
    }

    public static void setServerPlatform(String serverPlatform) {
        RequestUtil.serverPlatform = serverPlatform;
    }
}
