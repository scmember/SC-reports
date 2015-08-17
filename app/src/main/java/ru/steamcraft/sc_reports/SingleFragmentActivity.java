package ru.steamcraft.sc_reports;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager _fragmentManager = getSupportFragmentManager();
        Fragment _fragment = _fragmentManager.findFragmentById(R.id.fragment_container);
        if (_fragment == null) {
            _fragment = createFragment();
            _fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, _fragment)
                    .commit();
        }
    }
}
