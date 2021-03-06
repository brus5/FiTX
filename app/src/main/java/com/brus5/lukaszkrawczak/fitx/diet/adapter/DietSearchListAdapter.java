package com.brus5.lukaszkrawczak.fitx.diet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brus5.lukaszkrawczak.fitx.R;
import com.brus5.lukaszkrawczak.fitx.diet.Product;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by lukaszkrawczak on 18.03.2018.
 */

public class DietSearchListAdapter extends ArrayAdapter<Product>
{
    private static final String TAG = "DietListAdapter";
    private int mResource;
    private Context mContext;

    public DietSearchListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> objects)
    {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        int id = getItem(position).getId();
        String name = getItem(position).getName();
        double kcal = getItem(position).getKcal();
        int verified = getItem(position).getVerified();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView dietMealID = convertView.findViewById(R.id.dietMealSearchID);
        TextView dietMealTitle = convertView.findViewById(R.id.trainingSearchTitle);
        TextView dietMealKcal = convertView.findViewById(R.id.dietMealSearchKcal);
        ImageView imageViewSearchProductVerified = convertView.findViewById(R.id.imageViewSearchProductVerified);

        dietMealID.setText(String.valueOf(id));

        dietMealTitle.setText(name);

        dietMealKcal.setText(replaceCommaWithDotNoFloatingPoint(kcal));


        if (verified == 0)
        {
            imageViewSearchProductVerified.setVisibility(View.INVISIBLE);
        }


        return convertView;
    }

    private String replaceCommaWithDotNoFloatingPoint(double value)
    {
        return String.format(Locale.getDefault(), "%.0f", value).replace(",", ".");
    }
}