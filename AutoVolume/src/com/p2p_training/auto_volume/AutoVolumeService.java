package com.p2p_training.auto_volume;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class AutoVolumeService extends Service {
	
	private static final String TAG = "AutoVolumeService";
	
	private TelListener _telListener = null;
	private TelephonyManager _telM = null;
	private boolean _listened = false;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Log.v(TAG, "AutoVolumeService onCreate");
		
		Log.v(TAG, "to init VolumeHandler");
		
		VolumeHandler.init(getApplicationContext());
		
		_telListener = new TelListener( this.getApplicationContext() );
		_telM = (TelephonyManager) this.getApplicationContext().getSystemService(TELEPHONY_SERVICE);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
		Log.v(TAG, "onDestroy");
		
		if (_listened) {
			Log.v(TAG, "Stop telephony listen.");
			_telM.listen(_telListener, PhoneStateListener.LISTEN_NONE);
			_listened = false;
		}
		
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		Log.v(TAG, "onStartCommand...");
		
		if (!_listened) {
			Log.v(TAG, "Start to telephony listen...");
			_telM.listen(_telListener, PhoneStateListener.LISTEN_CALL_STATE);
			_listened = true;
		}
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
