package com.talenguyen.TaleSamples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.talenguyen.TaleSamples.widgets.ToggleStarButton;

public class MyActivity extends Activity {
    private static final String TAG = MyActivity.class.getSimpleName();

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ToggleStarButton checkbox = (ToggleStarButton) findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new ToggleStarButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ToggleStarButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: " + isChecked);
            }
        });
    }

    private static class GridAdapter extends ArrayAdapter<String> {

        public GridAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }
}
