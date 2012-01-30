package com.p2p_training.auto_volume;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AutoVolumeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//        Context context = this.getApplicationContext();
//		TelephonyManager telM = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//		telM.listen(new TelListener(context), PhoneStateListener.LISTEN_CALL_STATE);

        Context context = this.getApplicationContext();
        context.startService(new Intent(context, AutoVolumeService.class));
    }
}