package com.brus5.lukaszkrawczak.fitx.settings.list;

/**
 * Settings object, for creating objects in ListView
 */
public class Settings
{
    private String name;
    private String value;
    private String description;
    private String db;
    private int viewType;
    private String descriptionLong;
    private String[] items;
    private int valNum;

    public Settings(String name, String value, String description, String db, int viewType, String descriptionLong)
    {
        this.name = name;
        this.value = value;
        this.description = description;
        this.db = db;
        this.viewType = viewType;
        this.descriptionLong = descriptionLong;
    }

    public Settings(String name, String value, String description, String db, int viewType, String descriptionLong, String[] items, int valNum)
    {
        this.name = name;
        this.value = value;
        this.description = description;
        this.db = db;
        this.viewType = viewType;
        this.descriptionLong = descriptionLong;
        this.items = items;
        this.valNum = valNum;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public String getDescription()
    {
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

    public String getDescriptionLong()
    {
        return descriptionLong;
    }

    public String[] getItems()
    {
        return items;
    }

    public int getValNum()
    {
        return valNum;
    }
}
