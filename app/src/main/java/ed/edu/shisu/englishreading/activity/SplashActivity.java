package ed.edu.shisu.englishreading.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import ed.edu.shisu.englishreading.R;


/**
 * Created by haganwu on 16/8/21.
 */

public class SplashActivity extends Activity {

    private Handler mMainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClass(getApplication(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            // overridePendingTransition must be called AFTER finish() or startActivity, or it won't work.
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.mipmap.splash);
        mMainHandler.sendEmptyMessageDelayed(0, 3000);
    }

    // much easier to handle key events
    @Override
    public void onBackPressed() {
    }
}