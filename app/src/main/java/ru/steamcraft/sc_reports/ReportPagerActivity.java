package ru.steamcraft.sc_reports;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.UUID;

public class ReportPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ArrayList<Report> mReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.view_pager);
        setContentView(mViewPager);

        mReports = ReportLab.get(this).getReports();

        FragmentManager _fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(_fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Report _report = mReports.get(position);
                return ReportFragment.newInstance(_report.getId());
            }

            @Override
            public int getCount() {
                return mReports.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Report _report = mReports.get(position);
                if (_report.getTitle() != null) {
                    setTitle(_report.getTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID _reportId = (UUID)getIntent().getSerializableExtra(ReportFragment.EXTRA_REPORT_ID);
        for(int i=0; i<mReports.size(); i++){
            if(mReports.get(i).getId().equals(_reportId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
