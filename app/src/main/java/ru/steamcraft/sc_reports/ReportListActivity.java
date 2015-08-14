package ru.steamcraft.sc_reports;

import android.app.Fragment;

/**
 * Created by scmember on 14.08.2015.
 */
public class ReportListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ReportListFragment();
    }
}
