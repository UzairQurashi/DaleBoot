package app.dalboot.mobiavialdo.com.daleboot.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Author: Uzair Qureshi
 * Date:  5/19/17.
 * Description:
 * this is the custome viewpager in which finger swipe effect will be disable
 */

public class NonSwipeableViewpager extends ViewPager {
    public NonSwipeableViewpager(Context context) {
        super(context);
    }

    public NonSwipeableViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //return super.onTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }


}
