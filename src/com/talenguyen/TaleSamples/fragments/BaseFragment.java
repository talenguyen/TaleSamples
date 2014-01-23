package com.talenguyen.TaleSamples.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {

    public static final String KEY_NAME = "key_name";
    public String TAG;

	public BaseFragment() {
		// Required empty public constructor
        TAG = getClass().getSimpleName();
	}

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            return;
        }
        TAG += name;
    }

    public String getTAG() {
        return TAG;
    }

    @Override
	public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
	public void onAttach(Activity activity) {
        Log.d(TAG, "onAttach");
        super.onAttach(activity);
	}

	@Override
	public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
	}

	@Override
	public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

	@Override
	public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();

	}

	@Override
	public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

	@Override
	public void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
	}

	@Override
	public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }
}
