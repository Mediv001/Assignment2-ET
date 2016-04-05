package com.example.english.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by english on 30/03/2016.
 */
public class CustomView extends View {
    private Paint black;
    private Paint grey;
    private Cells[] touchx;// x position of each touch
    private Rect[] listcase;
    private boolean touch;// do we have at least on touch
    private Paint red;

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
        int right = 55;
        int bot = 55;
        black = new Paint(Paint.ANTI_ALIAS_FLAG);
        black.setColor(0xF0000000);
        grey = new Paint(Paint.ANTI_ALIAS_FLAG);
        grey.setColor(0xFF808080);
        red = new Paint(Paint.ANTI_ALIAS_FLAG);
        red.setColor(Color.RED);
        listcase = new Rect[100];
        touchx = new Cells[100];

        Random rand = new Random();

        int j = 0;
        for (int i = 0; i < 100; i++, j++){
            if(j > 9) {
                top += 60;
                bot += 60;
                left = 0;
                right = 55;
                j = 0;
            }
            touchx[i] = new Cells(0, true, new Rect(left, top, right, bot), black);
            left += 60;
            right += 60;
            listcase[i] = touchx[i].getXy();
        }
        for(int i = 0; i < 20; i++) {
            addmine(rand);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 100; i++) {
                touchx[i].Draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();
        int yolo = search(eventX, eventY);
        if(yolo != -1){
            touchx[yolo].setCover(false);
            if(touchx[yolo].isMines()){
                touchx[yolo].setColor(red);
                touchx[yolo].setCover(false);
            }
            else {
                touchx[yolo].setColor(grey);
                touchx[yolo].setCover(true);
            }
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public int search(float x, float y){
        for(int i = 0; i < 100; i++){
            if(listcase[i].contains((int)x, (int)y))
                return i;
        }
        return -1;
    }

    public void addmine(Random rand){
        int mine = rand.nextInt(100);
        if(touchx[mine].isMines()){
            addmine(rand);
        }else{
            touchx[mine].setMines(true);
        }
    }
}