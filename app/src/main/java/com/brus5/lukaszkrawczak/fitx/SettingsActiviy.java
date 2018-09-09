package com.brus5.lukaszkrawczak.fitx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.brus5.lukaszkrawczak.fitx.utils.ActivityView;
import com.brus5.lukaszkrawczak.fitx.utils.DateGenerator;

import java.util.ArrayList;
import java.util.List;

public class SettingsActiviy extends AppCompatActivity implements IDefaultView
{
    private DateGenerator cfg = new DateGenerator();
    private ArrayList<Settings> list = new ArrayList<>();
    private ListView listView;
    private SettingsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        loadInput();
        loadDefaultView();

        onListViewItemSelected();

        Settings s1 = new Settings();
        s1.name = "Waga";
        s1.value = "100 kg";
        s1.description = "Waga wyrażona w kilogramach";
        s1.viewType = 1;
        s1.db = "user_weight";
        list.add(s1);

        Settings s2 = new Settings();
        s2.name = "Wzrost";
        s2.value = "180 cm";
        s2.description = "Wzrost wyrażony w centymetrach";
        s2.viewType = 1;
        s2.db = "user_height";
        list.add(s2);

        Settings s3 = new Settings();
        s3.name = "Automatyczny limit kalorii";
        s3.description = "Włącz lub wyłącz auto limit kalorii";
        s3.viewType = 2;
        list.add(s3);

        Settings s4 = new Settings();
        s4.name = "Somatotyp";
        s4.value = "+200 kcal";
        s4.description = "Somatotyp opisujący sylwetkę";
        s4.viewType = 1;
        list.add(s4);

        Settings s5 = new Settings();
        s5.name = "Stosunek makroskładników";
        s5.value = "40/30/30";
        s5.description = "Stosunek makroskładników pozwalający ograniczyć niepotrzebne kalorie";
        s5.viewType = 1;
        list.add(s5);

        Settings s6 = new Settings();
        s6.name = "Cel diety";
        s6.value = "Utrata wagi";
        s6.description = "Jaki cel ma mieć aktualna dieta";
        s6.viewType = 1;
        list.add(s6);


        adapter = new SettingsAdapter(this,R.layout.row_settings,list);
        listView.setAdapter(adapter);
        listView.invalidate();
    }

    @Override
    public void loadInput()
    {
        listView = findViewById(R.id.listViewSettings);
    }

    @Override
    public void loadDefaultView()
    {
        ActivityView activityView = new ActivityView(SettingsActiviy.this, getApplicationContext(), this);
        activityView.statusBarColor(R.id.toolbarSettingsActivity);
        activityView.showBackButton();
    }

    private void onBackButtonPressed()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void onListViewItemSelected() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                TextView tvViewType = view.findViewById(R.id.textViewSettingsViewType);
                TextView tvViewTitle = view.findViewById(R.id.textViewTitle);

                Intent intent = new Intent(SettingsActiviy.this, SettingsDetailsActivity.class);
                intent.putExtra("viewType", Integer.valueOf(tvViewType.getText().toString()));
                intent.putExtra("viewTitle", tvViewTitle.getText().toString());
                SettingsActiviy.this.startActivity(intent);
            }
        });
    }




    private class Settings
    {
        String name;
        String value;
        String description;
        String db;
        int viewType;

        public String getName()
        {
            return name;
        }

        public String getValue()
        {
            return value;
        }

        public String getDescription() {
            return description;
        }

        public int getViewType()
        {
            return viewType;
        }

        public String getDb()
        {
            return db;
        }
    }

    private class SettingsAdapter extends ArrayAdapter<Settings>
    {
        private Context mContext;
        private int mResource;

        public SettingsAdapter(@NonNull Context context, int resource, @NonNull List<Settings> objects)
        {
            super(context, resource, objects);
            this.mContext = context;
            this.mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            String name = getItem(position).getName();
            String value = getItem(position).getValue();
            String description = getItem(position).getDescription();
            int viewType = getItem(position).getViewType();
            String db = getItem(position).getDb();

            if (viewType == 1)
            {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.row_settings, parent, false);

                TextView tvTitle = convertView.findViewById(R.id.textViewTitle);
                TextView tvValue = convertView.findViewById(R.id.textViewValue);
                TextView tvViewType = convertView.findViewById(R.id.textViewSettingsViewType);
                TextView tvDescription = convertView.findViewById(R.id.textViewDescription);

                tvTitle.setText(name);
                tvValue.setText(value);
                tvDescription.setText(description);
                tvViewType.setText(String.valueOf(viewType));

                System.out.println("DB: " + db);


                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        System.out.println("CLICKED");
                    }
                });

            }

            if (viewType == 2)
            {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.row_settings_switch, parent, false);

                TextView tvTitle = convertView.findViewById(R.id.textViewTitle);
                TextView tvDescription = convertView.findViewById(R.id.textViewDescription);
                Switch aSwitch = convertView.findViewById(R.id.switch1);
                TextView tvViewType = convertView.findViewById(R.id.textViewSettingsViewType);

                tvTitle.setText(name);
                tvDescription.setText(description);
                tvViewType.setText(String.valueOf(viewType));

                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
                {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b)
                    {
                        if (b)
                        {
                            Toast.makeText(mContext, "ON", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(mContext, "OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

                return convertView;
        }
    }



}
