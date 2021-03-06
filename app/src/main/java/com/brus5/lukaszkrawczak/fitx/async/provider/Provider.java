package com.brus5.lukaszkrawczak.fitx.async.provider;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.brus5.lukaszkrawczak.fitx.MainService;
import com.brus5.lukaszkrawczak.fitx.async.HTTPService;
import com.brus5.lukaszkrawczak.fitx.utils.SaveSharedPreference;
import com.jjoe64.graphview.GraphView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.brus5.lukaszkrawczak.fitx.utils.RestAPI.URL_MAIN_KCAL_LIMIT_UPDATE;

public class Provider
{
    private static final String TAG = "Provider";
    private ListView listView;
    private Activity activity;
    private Context context;
    private GraphView graphView;

    public Provider(Context context, ListView listView)
    {
        this.context = context;
        this.listView = listView;
    }

    public Provider(Activity activity, Context context)
    {
        this.activity = activity;
        this.context = context;
    }

    public Provider(Context context, GraphView graphView)
    {
        this.context = context;
        this.graphView = graphView;
    }

    public Provider(Context context)
    {
        this.context = context;
    }


    /**
     * This method loads proper class. It's must have to run out AsyncTask
     */
    public void load()
    {
        // Getting variables to update user_kcal_limit table
        String id = String.valueOf(SaveSharedPreference.getUserID(context));
        Calendar cal = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = sdf.format(cal.getTime());
        Log.i(TAG, "load: " + SaveSharedPreference.getUserAutoCalories(context));

        if (SaveSharedPreference.getUserAutoCalories(context) == 1)
        {
            final String LINK = URL_MAIN_KCAL_LIMIT_UPDATE + "?user_id=" + id + "&date=" + date;
            // Inserting OR Updating user_kcal_limit table
            new MainService(context).post(LINK);
        }

        switch (context.getClass().getSimpleName())
        {
            case "MainActivity":
                new MainActivityProvider(context, listView);
                break;
            case "DietActivity":
                new DietActivityProdiver(context, listView);
                break;
            case "TrainingActivity":
                new TrainingActivityProvider(context, listView);
                break;
            case "SettingsActivity":
                new SettingsActivityProvider(context);
                break;
        }
    }


    /**
     * This method load proper class with String param as one of communicators with HTTPService
     *
     * @param s param with will be passed to Rest Service
     */
    public void load(final String s)
    {
        switch (context.getClass().getSimpleName())
        {
            case "DietProductSearchActivity":
                new DietProductSearchActivityProvider(context, listView, s);
                break;
        }
    }

    /**
     * This method starts HTTP Service which witch AsyncTask
     *
     * @param link   is an private final static field in RestApi.class this is main link to server
     * @param params is string of parameters it's for example: "?product_id=4"
     */
    protected void startHTTPService(String link, String params)
    {
        HTTPService HTTPService = new HTTPService(activity, context, listView);
        HTTPService.execute(link, params);
    }


}



