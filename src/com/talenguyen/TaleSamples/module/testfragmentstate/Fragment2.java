package com.talenguyen.TaleSamples.module.testfragmentstate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.talenguyen.TaleSamples.fragments.BaseFragment;

/**
 * Created by TALE on 1/23/14.
 */
public class Fragment2 extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(android.R.layout.simple_list_item_1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        text1.setText(TAG);
    }
}
