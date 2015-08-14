package ru.steamcraft.sc_reports;

import android.app.Fragment;

public class ReportActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ReportFragment();
    }
}
