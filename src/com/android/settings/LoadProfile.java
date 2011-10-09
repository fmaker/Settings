package com.android.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

import android.app.Activity;
import android.os.Bundle;

public class LoadProfile extends Activity {
	private static final String TAG = "LoadProfile";

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		File output = new File("/data/system/","battery_log.csv");
		File input = new File("/sdcard/","battery_log.csv");
		FileChannel src,dest;

		try{

		    if(!output.exists()) {
		    	output.createNewFile();
		    }

			src = new FileInputStream(input).getChannel();
			dest = new FileInputStream(output).getChannel();
			dest.transferFrom(src, 0, src.size());
			

	        if(src != null) {
	            src.close();
	        }
	        if(dest != null) {
	            dest.close();
	        }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
