package com.talenguyen.TaleSamples.module.testfragmentstate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.talenguyen.TaleSamples.R;
import com.talenguyen.TaleSamples.fragments.BaseFragment;

/**
 * Created by TALE on 1/23/14.
 */
public class TestFragmentState extends FragmentActivity implements View.OnClickListener {

    private int index = 1;
    private String currentFragmentTAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_state);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.replace).setOnClickListener(this);
        findViewById(R.id.remove).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.add:
                final BaseFragment addedFragment = getFragment();
                addFragment(addedFragment);
                break;
            case R.id.replace:
                final BaseFragment replacedFragment = getFragment();
                replaceFragment(replacedFragment);
                break;

            case R.id.remove:
                if (currentFragmentTAG == null) {
                    return;
                }
                final BaseFragment removedFragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(currentFragmentTAG);
                removeFragment(removedFragment);
                break;
        }
    }

    public void addFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, fragment.getTAG()).commit();
        currentFragmentTAG = fragment.getTAG();
    }

    public void replaceFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, fragment.getTAG()).commit();
        currentFragmentTAG = fragment.getTAG();
    }

    public void removeFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    public BaseFragment getFragment() {
        BaseFragment fragment = null;
        switch (index) {
            case 1:
                fragment = new Fragment1();
                break;
            case 2:
                fragment = new Fragment2();
                break;
            case 3:
                fragment = new Fragment3();
                break;
        }
        index++;
        if (index > 3) {
            index = 1;
        }
        return fragment;
    }


}
