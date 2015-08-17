package ru.steamcraft.sc_reports;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


public class ReportFragment extends Fragment {

    public static final String EXTRA_REPORT_ID = "ru.steamcraft.sc_reports.reportintent.report_id";

    private Report mReport;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSavedCheckBox;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ReportFragment.
     */
    public static ReportFragment newInstance(UUID reportId) {
        ReportFragment _fragment = new ReportFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_REPORT_ID, reportId);
        _fragment.setArguments(args);
        return _fragment;
    }

    public ReportFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID _reportId = (UUID)getArguments().getSerializable(EXTRA_REPORT_ID);
        mReport = ReportLab.get(getActivity()).getReport(_reportId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _view = inflater.inflate(R.layout.fragment_report, container, false);
        mTitleField = (EditText) _view.findViewById(R.id.report_title);
        mTitleField.setText(mReport.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //пока пусто
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mReport.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //пока пусто
            }
        });

        mDateButton = (Button) _view.findViewById(R.id.report_date);
        mDateButton.setText(mReport.getDate().toString());
        mDateButton.setEnabled(false);

        mSavedCheckBox = (CheckBox) _view.findViewById(R.id.report_saved);
        mSavedCheckBox.setChecked(mReport.isSaved());
        mSavedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO: 13.08.2015 сделать сохранение репорта на сервере и навсегда неактивную галку
                mReport.setSaved(isChecked);
            }
        });

        return _view;
    }

}
