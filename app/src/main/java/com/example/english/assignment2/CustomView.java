package com.example.english.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by english on 30/03/2016.
 */
public class CustomView extends View {
    /*private Paint black;
    private Rect square;// the square itself
    private boolean touches[];// which fingers providing input
    private float touchx[];// x position of each touch
    private float touchy[];// y position of each touch
    private int first;// the first touch to be rendered
    private boolean touch;// do we have at least on touch*/

    public CustomView(Context c) {
        super(c);
        init();
    }

    public CustomView(Context c, AttributeSet as) {
        super(c, as);
        init();
    }

    public CustomView(Context c, AttributeSet as, int default_style) {
        super(c, as, default_style);
        init();
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        } else {
            setMeasuredDimension(measuredWidth, measuredWidth);

        }
    }

    private void init() {
        /*black = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(0xF0000000);

        touches = new boolean[10];
        touchx = new float[10];
        touchy = new float[10];

        for(int i = 0; i < 10; i++) {
            touchx[i] = 100.f + i*square.height();
            touchy[i] = 100.f + i*square.height();
        }

        square = new Rect(-20, -20, 20, 20);

        touch = false;*/
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(touchx[i], touchy[i]);
            canvas.drawRect(square, black);
            canvas.restore();
        }*/
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
