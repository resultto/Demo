package www.test.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.test.com.myapplication.adapter.ProvinceAdapter;
import www.test.com.myapplication.model.ProvinceBean;


/**
 * Created by Administrator on 2019/3/7.
 */

public class MainActiviey3 extends Activity {
    private GridView mGridView;
    private ProvinceAdapter mProvinceAdapter;
    private String[] provinceNames = new String[]{"北京", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东", "北京", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东", "上海", "广东", "广西", "天津", "重庆", "湖北", "湖南", "河北", "河南", "山东"};
    private int[] bgColor = new int[]{R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent,
            R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent, R.color.colorPrimaryDark,
            R.color.colorAccent, R.color.colorPrimary};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        TextView tv1 = (TextView) this.findViewById(R.id.tv1);
        TextView tv2 = (TextView) this.findViewById(R.id.tv2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int lastVisiblePosition = mGridView.getLastVisiblePosition();
//                mGridView.smoothScrollToPosition(lastVisiblePosition + 1);
            }
        });
        mGridView = (GridView) this.findViewById(R.id.gv);
        GridViewAutoScrollHelper gridViewAutoScrollHelper = new GridViewAutoScrollHelper(mGridView);
        mGridView.setOnTouchListener(gridViewAutoScrollHelper);
        gridViewAutoScrollHelper.setEnabled(true);
//        mGridView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float y = event.getY();
//                Log.e("哈哈哈", y + "");
//                if (y > 1100)
//                    mGridView.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            mGridView.smoothScrollToPosition(mGridView.getLastVisiblePosition() + 1);
//                        }
//                    });
//
//                return false;
//            }
//        });
        List<ProvinceBean> provinceBeanList = new ArrayList<>();
        for (int i = 0; i < provinceNames.length; i++) {
            ProvinceBean provinceBean = new ProvinceBean();
            provinceBean.setName(provinceNames[i]);
            provinceBean.setColor(bgColor[i]);
            provinceBeanList.add(provinceBean);
        }
        mProvinceAdapter = new ProvinceAdapter(this, provinceBeanList);
        mGridView.setAdapter(mProvinceAdapter);
    }

}
