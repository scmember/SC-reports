package ru.steamcraft.sc_reports;

import android.app.Fragment;

import java.util.UUID;

public class ReportActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID reportId = (UUID)getIntent().getSerializableExtra(ReportFragment.EXTRA_REPORT_ID);
        return ReportFragment.newInstance(reportId);
    }
}
