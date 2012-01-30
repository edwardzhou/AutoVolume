package com.p2p_training.auto_volume;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

public class OutgoingCallReceiver extends BroadcastReceiver {
	
	private final String TAG = "PhoneBootReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Log.v(TAG, "calling " + intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER));
		
		AudioManager audM = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		
		Log.v(TAG, "isBluetoothA2dpOn : " + audM.isBluetoothA2dpOn());
		Log.v(TAG, "isBluetoothScoAvailableOffCall : " + audM.isBluetoothScoAvailableOffCall());
		Log.v(TAG, "isBluetoothScoOn : " + audM.isBluetoothScoOn());
		Log.v(TAG, "isMicrophoneMute : " + audM.isMicrophoneMute());
		Log.v(TAG, "isMusicActive : " + audM.isMusicActive());
		Log.v(TAG, "isSpeakerphoneOn : " + audM.isSpeakerphoneOn());
		Log.v(TAG, "isWiredHeadsetOn : " + audM.isWiredHeadsetOn());

	}

}
