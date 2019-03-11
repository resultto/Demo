package www.test.com.myapplication;

import android.support.v4.widget.AutoScrollHelper;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Administrator on 2019/3/8.
 */

public class GridViewAutoScrollHelper extends AutoScrollHelper {
    /**
     * Creates a new helper for scrolling the specified target view.
     * <p>
     * The resulting helper may be configured by chaining setter calls and
     * should be set as a touch listener on the target view.
     * <p>
     * By default, the helper is disabled and will not respond to touch events
     * until it is enabled using {@link #setEnabled}.
     *
     * @param target The view to automatically scroll.
     */
    GridView gridView;

    public GridViewAutoScrollHelper(View target) {
        super(target);
        gridView = (GridView) target;
    }

    @Override
    public void scrollTargetBy(int deltaX, int deltaY) {
        gridView.smoothScrollBy(deltaY, 100);

    }

    @Override
    public boolean canTargetScrollHorizontally(int direction) {
        return false;
    }

    @Override
    public boolean canTargetScrollVertically(int direction) {
        return gridView.canScrollVertically(direction);
    }
}
