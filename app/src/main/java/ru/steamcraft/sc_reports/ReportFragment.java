package ru.steamcraft.sc_reports;

import android.app.Fragment;
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


public class ReportFragment extends Fragment {
    private Report mReport;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSavedCheckBox;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReport = new Report();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _view = inflater.inflate(R.layout.fragment_report, container, false);
        mTitleField = (EditText) _view.findViewById(R.id.report_title);
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
