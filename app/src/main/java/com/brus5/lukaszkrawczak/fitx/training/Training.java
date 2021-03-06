package com.brus5.lukaszkrawczak.fitx.training;

import com.brus5.lukaszkrawczak.fitx.utils.StringConverter;

import java.util.ArrayList;

/**
 * Created by lukaszkrawczak on 18.03.2018.
 */

public class Training extends ArrayList
{
    private int viewType; /* 1: for Gym; 2: for Cardio */
    private int id;
    private int done;
    private String name;
    private int restTime;
    private String weight;
    private String reps;
    private int sets;
    private String timeStamp;
    private String target;
    private int time;
    private String kcalPerMin;
    private double kcal;
    private String notepad;


    private Training(Builder builder)
    {
        this.viewType = builder.viewType;
        this.id = builder.id;
        this.done = builder.done;
        this.name = builder.name;
        this.restTime = builder.restTime;
        this.weight = builder.weight;
        this.reps = builder.reps;
        this.timeStamp = builder.timeStamp;
        this.target = builder.target;
        this.time = builder.time;
        this.kcalPerMin = builder.kcalPerMin;
        this.kcal = builder.kcal;
        this.notepad = builder.notepad;
        this.sets = builder.sets;
    }

    public int getId()
    {
        return id;
    }

    public int getDone()
    {
        return done;
    }

    public String getName()
    {
        return StringConverter.toUpperFirstLetter(name);
    }

    public int getRestTime()
    {
        return restTime;
    }

    public String getWeight()
    {
        return weight;
    }

    public String getReps()
    {
        return reps;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public String getTarget()
    {
        return target;
    }

    public int getViewType()
    {
        return viewType;
    }

    public int getTime()
    {
        return time;
    }

    public String getKcalPerMin()
    {
        return kcalPerMin;
    }

    public double getKcal()
    {
        return kcal;
    }

    public String getNotepad()
    {
        return notepad;
    }

    public int getSets()
    {
        return sets;
    }

    @Override
    public String toString()
    {
        return "Training{" + "viewType=" + viewType + ", id=" + id + ", done=" + done + ", name='" + name + '\'' + ", restTime=" + restTime + ", weight='" + weight + '\'' + ", reps='" + reps + '\'' + ", timeStamp='" + timeStamp + '\'' + ", target='" + target + '\'' + ", time=" + time + ", kcalPerMin='" + kcalPerMin + '\'' + ", kcal=" + kcal + '}';
    }

    public static class Builder
    {

        private int viewType; /* 1: for Gym; 2: for Cardio */
        private int id;
        private int done;
        private String name;
        private int restTime;
        private String weight;
        private String reps;
        private String timeStamp;
        private String target;
        private int time;
        private String kcalPerMin;
        private double kcal;
        private String notepad;
        private int sets;

        public Builder viewType(int viewType)
        {
            this.viewType = viewType;
            return this;
        }

        public Builder id(int id)
        {
            this.id = id;
            return this;
        }

        public Builder done(int done)
        {
            this.done = done;
            return this;
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder weight(String weight)
        {
            this.weight = weight;
            return this;
        }

        public Builder reps(String reps)
        {
            this.reps = reps;
            return this;
        }

        public Builder timeStamp(String timeStamp)
        {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder target(String target)
        {
            this.target = target;
            return this;
        }

        public Builder time(int time)
        {
            this.time = time;
            return this;
        }

        public Builder kcalPerMin(String kcalPerMin)
        {
            this.kcalPerMin = kcalPerMin;
            return this;
        }

        public Builder kcal(double kcal)
        {
            this.kcal = kcal;
            return this;
        }


        public Builder notepad(String notepad)
        {
            this.notepad = notepad;
            return this;
        }


        public Builder sets(int sets)
        {
            this.sets = sets;
            return this;
        }

        public Training build()
        {
            return new Training(this);
        }


    }
}
