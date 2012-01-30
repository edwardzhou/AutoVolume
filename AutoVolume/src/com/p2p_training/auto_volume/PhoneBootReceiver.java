package com.p2p_training.auto_volume;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PhoneBootReceiver extends BroadcastReceiver {
	
	private final String TAG = "PhoneBootReceiver";
	private TelListener _listener = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Log.v(TAG, "start AutoVolumeService...");
		
//		if (_listener == null ) {
//			_listener = new TelListener(context);
//			TelephonyManager telM = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//			telM.listen(_listener, PhoneStateListener.LISTEN_CALL_STATE);
//		}
		
		// context.bindService(service, conn, flags)
		context.startService( new Intent(context, AutoVolumeService.class) );

	}

}
