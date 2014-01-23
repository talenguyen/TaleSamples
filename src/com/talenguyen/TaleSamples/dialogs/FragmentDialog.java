package com.talenguyen.TaleSamples.dialogs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.talenguyen.TaleSamples.R;

/**
 * Created by TALE on 1/17/14.
 */
public class FragmentDialog  extends FragmentActivity {

    private int instanceNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dialog);

        findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragmentDialog();
            }
        });
    }

    private void showFragmentDialog() {
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance(instanceNumber);
        dialogFragment.setCancelable(true);
        dialogFragment.show(getSupportFragmentManager(), "dialog");
        instanceNumber++;
    }
}
