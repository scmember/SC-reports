package ru.steamcraft.sc_reports;

import java.util.UUID;

/**
 * Created by scmember on 11.08.2015.
 */
public class Report {

    private UUID mId;
    private String mTitle;

    public Report(){
        mId = UUID.randomUUID();
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
