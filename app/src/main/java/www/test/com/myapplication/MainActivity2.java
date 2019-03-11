package www.test.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RelativeLayout rlContent;
    float initWidth;
    float expectWidth;
    int tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button bt = findViewById(R.id.bt);
        Button bt1 = findViewById(R.id.bt1);
        Button btClick = findViewById(R.id.bt_click);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "哈哈哈", Toast.LENGTH_SHORT).show();
            }
        });

        rlContent = findViewById(R.id.rl_content);
        rlContent.post(new Runnable() {
            @Override
            public void run() {
                initWidth = rlContent.getWidth();
            }
        });
        expectWidth = DisplayUtil.dip2px(MainActivity2.this, 200);
        tran = DisplayUtil.dip2px(MainActivity2.this, 150);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float scale = expectWidth / initWidth;
                setAni(scale, tran, tran);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float scale = initWidth / expectWidth;
                setAni(scale, 0, -tran);
            }
        });
    }

    public void setAni(float scale, int Magin, int Tran) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(getScale(scale, Magin));
        animationSet.addAnimation(getTran(Tran));
        animationSet.setFillAfter(true);
        rlContent.startAnimation(animationSet);
    }

    public ScaleAnimation getScale(final float scale, final int Margin) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, scale, 1.0f, scale);
        scaleAnimation.setDuration(500);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlContent.clearAnimation();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rlContent.getLayoutParams();
                layoutParams.setMargins(Margin, Margin, 0, 0);
                layoutParams.width = (int) (layoutParams.width * scale);
                layoutParams.height = (int) (layoutParams.height * scale);
                rlContent.setLayoutParams(layoutParams);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return scaleAnimation;
    }

    public TranslateAnimation getTran(float tran) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, tran, 0, tran);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }
}
