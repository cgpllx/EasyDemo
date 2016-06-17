package cc.easyandroid.easydemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cgpllx on 2016/6/17.
 */
public class QfangSearchBehavior<T extends View> extends CoordinatorLayout.Behavior<T> {

    int dependencyId;
    int targetId;

    public QfangSearchBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.QfangSearchTextView);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.QfangSearchTextView_dependencyId) {
                dependencyId = a.getResourceId(attr, -1);
            } else if (attr == R.styleable.QfangSearchTextView_targetId) {
                targetId = a.getResourceId(attr, -1);
            }
        }
        a.recycle();
    }

    public QfangSearchBehavior() {
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, T child, View dependency) {
        return dependency.getId() == dependencyId;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, T child, View dependency) {
        View view = parent.findViewById(targetId);//最终悬浮是toolbar上面
        int childHeight = child.getHeight();
        float toolbarY = view.getY();
        if (child.getY() >= toolbarY) {
            float cy = dependency.getY() + dependency.getHeight() - (childHeight + 50);
            if (cy < toolbarY) {
                child.setY(toolbarY);
            } else {
                child.setY(dependency.getY() + dependency.getHeight() - (childHeight + 50));
            }
        } else {
            child.setY(toolbarY);
        }
        return true;
    }
}
