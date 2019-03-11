package www.test.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 */
public class EditBookTab3Fragment extends Fragment {
    private ViewGroup viewGroup;


    public interface onTabSwitch {
        void swich(boolean isSwitch);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_edit_book_tab3, null, false);
        return viewGroup;
    }



}
