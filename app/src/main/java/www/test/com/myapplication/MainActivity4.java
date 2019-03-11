package www.test.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2019/3/8.
 */

public class MainActivity4 extends Activity {
    ImageView iv;
    RelativeLayout rl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        SeekBar sb = findViewById(R.id.sb);

        rl = findViewById(R.id.rl);

        iv = findViewById(R.id.iv);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("哈哈哈", progress / 2 + "");

                if (progress <= 255) {
                    iv.setImageResource(R.drawable.nav_icon_more_black);
                    iv.setAlpha(255 - progress);
                } else {
                    iv.setImageResource(R.drawable.nav_icon_more_white);
                    iv.setAlpha(progress % 255);
                }

                rl.setAlpha(Float.valueOf(progress - 409) / 100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
