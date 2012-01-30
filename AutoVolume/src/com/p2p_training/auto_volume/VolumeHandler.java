package com.p2p_training.auto_volume;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

public class VolumeHandler {
	
	private static final String TAG = "VolumeHandler";
	
	private static VolumeHandler _this = null;
	private Context _context;
	private AudioManager _audioManager;
	private int _lastMediaVolume = -1;
	private int _maxMediaVolume;
	
	private VolumeHandler(Context context) {
		this._context = context;
		_audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		_maxMediaVolume = _audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		Log.v(TAG, String.format("the max music volumn is: %d", _maxMediaVolume));
	}
	
	public static void init(Context context){
		if (_this == null )
			_this = new VolumeHandler(context);
	}
	
	public static VolumeHandler getInstance() {
		return _this;
	}
	
	public void maximizeMediaVolume() {
		if (_lastMediaVolume < 0) {
			_lastMediaVolume = _audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
			Log.v(TAG, String.format("current music volume: %d", _lastMediaVolume));
			_audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, _maxMediaVolume, AudioManager.FLAG_SHOW_UI);
		}
	}
	
	public void restoremediaVolume() {
		if (_lastMediaVolume >= 0) {
			Log.v(TAG, String.format("restore music volume to: %d", _lastMediaVolume));
			_audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, _lastMediaVolume, AudioManager.FLAG_SHOW_UI);
			_lastMediaVolume = -1;
		}
	}

}
