package ru.steamcraft.sc_reports;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * Created by scmember on 14.08.2015.
 */
public abstract class SingleFragmentActivity extends Activity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager _fragmentManager = getFragmentManager();
        Fragment _fragment = _fragmentManager.findFragmentById(R.id.fragment_container);
        if (_fragment == null) {
            _fragment = createFragment();
            _fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, _fragment)
                    .commit();
        }
    }
}
