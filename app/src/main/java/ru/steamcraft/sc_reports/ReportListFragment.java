package ru.steamcraft.sc_reports;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportListFragment extends ListFragment{
    private static final String TAG = "ReportListFragment";

    private ArrayList<Report> mReports;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.reports_title);
        mReports = ReportLab.get(getActivity()).getReports();

        ReportAdapter _adapter = new ReportAdapter(mReports);
        setListAdapter(_adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ReportAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Report _report = ((ReportAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, _report.getTitle() + " was clicked");
        Intent _intent = new Intent(getActivity(), ReportActivity.class);
        _intent.putExtra(ReportFragment.EXTRA_REPORT_ID, _report.getId());
        startActivity(_intent);
    }

    private class ReportAdapter extends ArrayAdapter<Report>{

        public ReportAdapter(ArrayList<Report> newReports) {
            super(getActivity(), 0, newReports);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //если нет представления, заполняем его
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_report, null);
            }

            Report _report = getItem(position);
            TextView _titleTextView = (TextView)convertView.findViewById(R.id.list_item_report_title_textview);
            _titleTextView.setText(_report.getTitle());
            TextView _dateTextView = (TextView)convertView.findViewById(R.id.list_item_report_date_textview);
            _dateTextView.setText(_report.getDate().toString());
            CheckBox _savedCheckBox = (CheckBox)convertView.findViewById(R.id.list_item_report_solved_checkbox);
            _savedCheckBox.setChecked(_report.isSaved());

            return convertView;
        }
    }
}
