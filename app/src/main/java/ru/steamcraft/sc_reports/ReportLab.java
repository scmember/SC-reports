package ru.steamcraft.sc_reports;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class ReportLab {
    private static ReportLab sReportLab;
    private Context mAppContext;
    private ArrayList<Report> mReports;

    public static ReportLab get(Context newAppContext) {
        if(sReportLab == null){
            sReportLab = new ReportLab(newAppContext.getApplicationContext());
        }
        return sReportLab;
    }

    private ReportLab(Context newAppContext) {
        mAppContext = newAppContext;
        mReports = new ArrayList<>();
        for(int i=0; i<100; i++){
            Report _report = new Report();
            _report.setTitle("Report #" + i);
            _report.setSaved(i%2 == 0);
            mReports.add(_report);
        }
    }

    public ArrayList<Report> getReports() {
        return mReports;
    }

    public Report getReport(UUID newUUID){
        for(Report v : mReports){
            if(v.getId().equals(newUUID)){
                return v;
            }
        }
        return null;
    }
}
