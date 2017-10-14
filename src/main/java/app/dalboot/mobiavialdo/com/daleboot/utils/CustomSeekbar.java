package app.dalboot.mobiavialdo.com.daleboot.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.SeekBar;

import app.dalboot.mobiavialdo.com.daleboot.R;

/**
 * Author: Uzair Qureshi
 * Date:  10/13/17.
 * Description:
 */

public class CustomSeekbar extends SeekBar {
    public CustomSeekbar(Context context) {
        super(context);
    }

    public CustomSeekbar (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomSeekbar (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        int thumb_x = (int) (( (double)this.getProgress()/this.getMax() ) * (double)this.getWidth());
        float middle = (float) (this.getHeight()/4);
//        canvas.drawText(text,bm.getWidth()/2, bm.getHeight()/4, paint);


        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        paint.setStyle(Paint.Style.FILL);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(30);
        c.drawText(""+this.getProgress()+"ft", thumb_x, middle, paint);
    }

}
