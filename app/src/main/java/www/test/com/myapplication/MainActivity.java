package www.test.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rl;
    Button btContent;
    TextView tvShow1;
    TextView tvShow2;
    TextView tvShow3;
    Button btLeft;
    Button btCenter;
    Button btRight;
    int anH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anH = DisplayUtil.dip2px(this, 100);
        rl = findViewById(R.id.rl);
        Button btOpen = findViewById(R.id.bt_open);
        Button btClose = findViewById(R.id.bt_close);


        btLeft = findViewById(R.id.bt_left);

        btCenter = findViewById(R.id.bt_center);

        btRight = findViewById(R.id.bt_right);
        tvShow1 = findViewById(R.id.tv_show1);

        tvShow2 = findViewById(R.id.tv_show2);

        tvShow3 = findViewById(R.id.tv_show3);

        btContent = findViewById(R.id.bt_content);
        btLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anH = DisplayUtil.dip2px(MainActivity.this, 100);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();
                } else {
                    setGone();
                    tvShow1.setVisibility(View.VISIBLE);
                    startOpen();

                }

            }
        });
        btCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anH = DisplayUtil.dip2px(MainActivity.this, 100);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();
                } else {
                    setGone();
                    tvShow2.setVisibility(View.VISIBLE);
                    startOpen();
                }
            }
        });
        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anH = DisplayUtil.dip2px(MainActivity.this, 200);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();
                } else {
                    setGone();
                    tvShow3.setVisibility(View.VISIBLE);
                    startOpen();
                }
            }
        });
        btContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
            }
        });
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOpen();
            }
        });
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startClose();
            }
        });

    }

    public void setGone() {
        tvShow1.setVisibility(View.GONE);
        tvShow2.setVisibility(View.GONE);
        tvShow3.setVisibility(View.GONE);
    }

    public void startOpen() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, DisplayUtil.dip2px(MainActivity.this, anH), 0);
        translateAnimation.setDuration(500);
        rl.startAnimation(translateAnimation);
        rl.setVisibility(View.VISIBLE);
    }

    public void startClose() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, DisplayUtil.dip2px(MainActivity.this, anH));
        translateAnimation.setDuration(500);
        rl.startAnimation(translateAnimation);
        rl.setVisibility(View.GONE);
    }
}
