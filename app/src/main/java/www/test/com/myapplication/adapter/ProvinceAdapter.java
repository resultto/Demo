package www.test.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import www.test.com.myapplication.R;
import www.test.com.myapplication.model.ProvinceBean;


/**
 * Created by Administrator on 2019/3/7.
 */

public class ProvinceAdapter extends BaseAdapter {

    private List<ProvinceBean> provinceBeanList;
    private LayoutInflater layoutInflater;

    public ProvinceAdapter(Context context, List<ProvinceBean> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.province_grid_view_item_layout, null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ProvinceBean provinceBean = provinceBeanList.get(position);
        if (provinceBean != null) {
            holder.text.setText(provinceBean.getName());
            holder.text.setBackgroundResource(provinceBean.getColor());
        }
        return convertView;
    }

    class ViewHolder {
        TextView text;
    }

}
