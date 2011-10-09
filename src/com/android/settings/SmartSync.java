package com.android.settings;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.IContentService;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SmartSync extends Activity {
	private static final String TAG = "SmartSync";
	Button b;
	boolean enableSmartSync = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smartsync);
		
		Log.d(TAG, "Button setup");
		b = (Button) findViewById(R.id.smartSyncButton);
		b.setText("smartSyncHook("+enableSmartSync+")");
		

		Log.d(TAG, "Content Service");
		final IContentService c = IContentService.Stub.asInterface(ServiceManager.getService(ContentResolver.CONTENT_SERVICE_NAME));
		
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try{
					c.smartSyncHook(enableSmartSync);
					
					// Flip the boolean and update button text
					enableSmartSync = !enableSmartSync;
					b.setText("smartSyncHook("+enableSmartSync+")");
				}catch(RemoteException e){
					e.printStackTrace();
				}
			}
		});
	}

}
