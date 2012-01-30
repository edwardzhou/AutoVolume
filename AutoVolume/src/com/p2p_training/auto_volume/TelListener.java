package com.p2p_training.auto_volume;

import android.content.Context;
import android.graphics.PixelFormat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

public class TelListener extends PhoneStateListener {
	private Context context;
	private final String TAG = "TelListener";
	private WindowManager wm;
	private TextView tv;

	public TelListener(Context context) {
		this.context = context;
	}

	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		super.onCallStateChanged(state, incomingNumber);

		Log.v(TAG, String.format("Call state: 0x%x", state));
		
		if ( TelephonyManager.CALL_STATE_RINGING == state || TelephonyManager.CALL_STATE_OFFHOOK == state ) {
			Log.v(TAG, "In call: " + incomingNumber);
			Log.v(TAG, "max music volume.");
			VolumeHandler.getInstance().maximizeMediaVolume();
		} else if (TelephonyManager.CALL_STATE_IDLE == state ) {
			Log.v(TAG, "call finished: " + incomingNumber);
			Log.v(TAG, "restore music volume.");
			VolumeHandler.getInstance().restoremediaVolume();
		}

//		if (TelephonyManager.CALL_STATE_RINGING == state) {
//			Log.v(TAG, "Calling " + incomingNumber);
//			wm = (WindowManager) context.getApplicationContext()
//					.getSystemService(Context.WINDOW_SERVICE);
//			WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//			params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//			params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//					| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//
//			params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//			params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//			params.format = PixelFormat.RGBA_8888;
//			tv = new TextView(context);
//			tv.setText("这是悬浮窗口，来电号码：" + incomingNumber);
//			wm.addView(tv, params);
//		} else if (TelephonyManager.CALL_STATE_IDLE == state) {
//			Log.v(TAG, "Call finished.");
//			if (wm != null && tv != null) {
//				wm.removeView(tv);
//				tv = null;
//			}
//		}
	}
	//

}
