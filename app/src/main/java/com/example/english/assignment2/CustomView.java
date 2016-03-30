package com.example.english.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by english on 30/03/2016.
 */
public class CustomView extends View {
    private Paint black;
    private boolean touches[];// which fingers providing input
    private Cells touchx[][];// x position of each touch
    private int first;// the first touch to be rendered
    private boolean touch;// do we have at least on touch

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
        int left = 0;
        int top = 0;
        int right = 50;
        int bot = 50;
        black = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(0xF0000000);

        touches = new boolean[100];
        touchx = new Cells[10][10];


        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                touches[i] = false;
                touchx[i][j] = new Cells(0, false, new int[]{left, top, right, bot}, black);
                left += 55;
                right += 55;
            }
            top += 55;
            bot += 55;
            left = 0;
            right = 50;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                touchx[i][j].Draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}