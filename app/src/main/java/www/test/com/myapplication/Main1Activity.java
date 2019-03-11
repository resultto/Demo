package www.test.com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main1Activity extends AppCompatActivity {
    RelativeLayout rl;
    Button btContent;
    TextView tvShow1;
    TextView tvShow2;
    TextView tvShow3;
    Button btLeft;
    Button btCenter;
    Button btRight;
    int anH;
    ViewGroup defaultShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        anH = DisplayUtil.dip2px(this, 100);
        rl = findViewById(R.id.rl);
        Button btOpen = findViewById(R.id.bt_open);
        Button btClose = findViewById(R.id.bt_close);
        defaultShow = findViewById(R.id.container);

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
                anH = DisplayUtil.dip2px(Main1Activity.this, 100);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();

                } else {
                    setGone();
                    tvShow1.setVisibility(View.VISIBLE);
                    switchTo(0);
                    startOpen();

                }

            }
        });
        btCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anH = DisplayUtil.dip2px(Main1Activity.this, 100);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();

                } else {
                    setGone();
                    tvShow2.setVisibility(View.VISIBLE);
                    switchTo(1);
                    startOpen();
                }
            }
        });
        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anH = DisplayUtil.dip2px(Main1Activity.this, 200);
                if (rl.getVisibility() == View.VISIBLE) {
                    startClose();

                } else {
                    setGone();
                    tvShow3.setVisibility(View.VISIBLE);
                    switchTo(2);
                    startOpen();
                }
            }
        });
        btContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main1Activity.this, "哈哈", Toast.LENGTH_SHORT).show();
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
        initFragments();
    }

    public void switchTo(int position) {
        switch (position)

        {
            case 0:
                switchFragment(getFragments().get(0));
                break;
            case 1:
                switchFragment(getFragments().get(1));
                break;
            case 2:
                switchFragment(getFragments().get(2));
                break;
        }

    }

    private void initFragments() {
        EditBookTab1Fragment homeFragment1 = new EditBookTab1Fragment();
        EditBookTab2Fragment homeFragment2 = new EditBookTab2Fragment();
        EditBookTab3Fragment homeFragment3 = new EditBookTab3Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", 0);
        homeFragment1.setArguments(bundle);
        homeFragment2.setArguments(bundle);
        fragments.add(homeFragment1);
        fragments.add(homeFragment2);
        fragments.add(homeFragment3);
        mManager = getSupportFragmentManager();
        FragmentTransaction transaction = mManager.beginTransaction();
        mFragmentBefor = getFragments().get(0);
        transaction.add(R.id.container, mFragmentBefor).commit();
    }

    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    private FragmentManager mManager;
    ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment mFragmentBefor;

    private void switchFragment(Fragment to) {
        try {
            if (mFragmentBefor != to) {
                FragmentTransaction transaction = mManager.beginTransaction();
                if (!to.isAdded()) {
                    transaction.hide(mFragmentBefor).add(R.id.container, to).commitAllowingStateLoss();
                } else {
                    transaction.hide(mFragmentBefor).show(to).commitAllowingStateLoss();
                }
                mFragmentBefor = to;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGone() {
        tvShow1.setVisibility(View.GONE);
        tvShow2.setVisibility(View.GONE);
        tvShow3.setVisibility(View.GONE);
    }

    public void startOpen() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, DisplayUtil.dip2px(Main1Activity.this, anH), 0);
        translateAnimation.setDuration(500);
        defaultShow.startAnimation(translateAnimation);
        defaultShow.setVisibility(View.VISIBLE);
    }

    public void startClose() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, DisplayUtil.dip2px(Main1Activity.this, anH));
        translateAnimation.setDuration(500);
        defaultShow.startAnimation(translateAnimation);
        defaultShow.setVisibility(View.GONE);
    }
}
