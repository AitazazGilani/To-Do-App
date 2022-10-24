package com.example.app.database;

public class Task implements TableObject<Task> {
    String name, date, time, category, duration, timespent ,contactName;

    /**
     *Time, duration, timespent must be in 24hour format
     * format: HH:MM:SS
     * Date must be in YYYY-MM-DD format
     */
    public Task(String name, String date, String time, String category, String duration, String timespent, String contactName) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.category = category;
        this.duration = duration;
        this.timespent = timespent;
        this.contactName = contactName;
    }

    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getTime() {
        return this.time;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getTimespent() {return this.timespent;}

    public String getContactName() {
        return this.contactName;
    }

    @Override
    public Task getObject() {
        return this;
    }

    @Override
    public String toString() {
        return "";
    }
}