package com.brus5.lukaszkrawczak.fitx.async.provider;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.brus5.lukaszkrawczak.fitx.RestAPI;
import com.brus5.lukaszkrawczak.fitx.SaveSharedPreference;
import com.brus5.lukaszkrawczak.fitx.dto.MainDTO;
import com.brus5.lukaszkrawczak.fitx.utils.DateGenerator;

class MainActivityProvider extends Provider
{
    private static final String TAG = "AsyncPrepMain";

    // Creating new object of MainDTO
    private MainDTO dto = new MainDTO();

    // Link from server to HTTP connection
    private static final String URL = RestAPI.SERVER_URL + "Main/Diet.php";

    /**
     * This constructor preparing SERVER_URL which should be sended to
     * startHTTPService.
     * Example SERVER_URL:
     * http://justfitx.xyz/Diet/ShowByUser.php?username=brus5&date=2018-08-27&user_id=5
     *
     * @param activity activity from current Activity
     * @param context  context from current Activity
     * @param listView listView from current Activity
     */
    MainActivityProvider(Activity activity, Context context, ListView listView)
    {
        super(activity, context, listView);

        // Attributing proper information to variables
        dto.userID = SaveSharedPreference.getUserID(context);
        dto.date = DateGenerator.getSelectedDate();

        // Glueing SERVER_URL with variables
        String params = "?user_id=" + dto.userID + "&date=" + dto.date;

        Log.d(TAG, "MainActivityProvider: " + params);

        // Starting AsyncTask after completing up SERVER_URL+params
        // This method is in Provider.class
        startHTTPService(URL, params);
    }


    /**
     * This method start AsyncTask after completing SERVER_URL + params
     * This method is in Provider.class
     *
     * @param link   it should be whole SERVER_URL for example: http://justfitx.xyz/Diet/ShowByUser.php
     * @param params it should named: ?username=brus5&date=2018-08-27&user_id=5
     */
    @Override
    protected void startHTTPService(String link, String params)
    {
        super.startHTTPService(link, params);
    }
}