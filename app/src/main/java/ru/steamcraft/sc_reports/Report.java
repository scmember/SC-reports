package ru.steamcraft.sc_reports;

import java.util.Date;
import java.util.UUID;

public class Report {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSaved;

    public Report(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSaved() {
        return mSaved;
    }

    public void setSaved(boolean saved) {
        mSaved = saved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
