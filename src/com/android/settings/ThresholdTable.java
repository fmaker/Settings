package com.android.settings;

import java.io.File;

import android.app.Activity;
import android.content.Profile;
import android.os.Bundle;
import android.util.Log;

public class ThresholdTable extends Activity {
	private static final String TAG = "ThresholdTable";

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d(TAG, "Creating Profile");
		Profile p = new Profile(getApplicationContext());

		Log.d(TAG, "Creating ThresholdTableGenerator");
		File tmp = getDir("array.bin", MODE_PRIVATE);
		Log.d(TAG, "tmp file = "+tmp);
		android.content.ThresholdTable table = new android.content.ThresholdTable(p);
		
		Log.d(TAG, "Got threshold table");
	}

}
