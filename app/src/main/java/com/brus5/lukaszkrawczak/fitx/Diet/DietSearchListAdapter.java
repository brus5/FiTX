package com.brus5.lukaszkrawczak.fitx.Diet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brus5.lukaszkrawczak.fitx.R;

import java.util.ArrayList;

/**
 * Created by lukaszkrawczak on 18.03.2018.
 */

public class DietSearchListAdapter extends ArrayAdapter<DietSearch>{

    private static final String TAG = "DietListAdapter";

    private Context mContext;
    int mResource;

    public DietSearchListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DietSearch> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RecyclerView.ViewHolder holder;

        final View result;

        int id = getItem(position).getId();
        String name = getItem(position).getName();
        double kcal = getItem(position).getKcal();
        int verified = getItem(position).getVerified();

        new DietSearch(id,name,kcal,verified);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent,false);

        TextView dietMealID = convertView.findViewById(R.id.dietMealSearchID);
        TextView dietMealTitle = convertView.findViewById(R.id.dietMealSearchTitle);
        TextView dietMealKcal = convertView.findViewById(R.id.dietMealSearchKcal);
        ImageView imageViewSearchProductVerified = convertView.findViewById(R.id.imageViewSearchProductVerified);

        dietMealID.setText(String.valueOf(id));

        dietMealTitle.setText(name);

        dietMealKcal.setText(replaceCommaWithDotNoFloatingPoint(kcal));


        ArrayList arrayList = new ArrayList();
        arrayList.add(kcal);

        if (verified == 0){
            imageViewSearchProductVerified.setVisibility(View.INVISIBLE);
        }

        Log.i(TAG, "getView: ArrayList "+arrayList);

        return convertView;
    }
    private String replaceCommaWithDotNoFloatingPoint(double value){
        return String.format("%.0f",value).replace(",",".");
    }

    private String replaceCommaWithDotWithFloatingPoint(double value){
        return String.format("%.1f",value).replace(",",".");
    }




}





















