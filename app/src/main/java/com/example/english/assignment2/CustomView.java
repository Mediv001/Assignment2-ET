package com.example.english.assignment2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


import java.util.Random;

/**
 * Created by english on 30/03/2016.
 */
public class CustomView extends View {
    public TextView tx;
    int number;
    private boolean marking;
    private boolean loose;
    private Paint black;
    private Paint grey;//uncover
    private Cells[] touchx;// x position of each touch
    private Rect[] listcase;
    private Paint red;
    private Paint yellow;

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
        number = 20;
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
        yellow = new Paint(Paint.ANTI_ALIAS_FLAG);
        yellow.setColor(Color.YELLOW);
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
            touchx[i] = new Cells(true, new Rect(left, top, right, bot), black);
            left += 60;
            right += 60;
            listcase[i] = touchx[i].getXy();
        }
        for(int i = 0; i < 20; i++) {
            addmine(rand);
        }

        loose = false;
        marking = false;
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (int i = 0; i < 100; i++) {
            touchx[i].Draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(!loose) {
            float eventX = event.getX();
            float eventY = event.getY();
            int yolo = search(eventX, eventY);
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP :
                    if (yolo != -1) {
                        if (!marking) {
                            touchx[yolo].setCover(false);
                            if (touchx[yolo].isMines()) {
                                touchx[yolo].setColor(red);
                                loose = true;
                            } else {
                                touchx[yolo].setColor(grey);
                            }
                        } else {
                            if (touchx[yolo].isMarked()) {
                                touchx[yolo].setColor(black);
                                touchx[yolo].setMarked(false);
                                actualizenumber('+');
                            } else {
                                touchx[yolo].setColor(yellow);
                                touchx[yolo].setMarked(true);
                                actualizenumber('-');
                            }
                            tx.setText("mines unmarked : " + number);
                        }
                    }
                    break;
            }
            invalidate();
        }
        return true;
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
            addnb(mine);
        }
    }

    public void addnb(int cell){
        if((cell+1) % 10 != 0){ //droite
            touchx[cell+1].setNb(touchx[cell + 1].getNb() + 1);
            if(cell > 9){ //haut droit
                touchx[cell-9].setNb(touchx[cell-9].getNb()+1);
            }
            if(cell < 90){ //bas droit
                touchx[cell+11].setNb(touchx[cell+11].getNb()+1);
            }
        }
        if(cell > 9){ //haut
            touchx[cell-10].setNb(touchx[cell-10].getNb()+1);
        }
        if(cell < 90){ //bas
            touchx[cell+10].setNb(touchx[cell+10].getNb()+1);
        }
        if(cell % 10 != 0){ //gauche
            touchx[cell - 1].setNb(touchx[cell - 1].getNb() + 1);
            if(cell > 9){ //haut gauche
                touchx[cell-11].setNb(touchx[cell-11].getNb()+1);
            }
            if(cell < 90){ //bas gauche
                touchx[cell+9].setNb(touchx[cell+9].getNb()+1);
            }
        }
    }

    public void change(){
        marking = !marking;
    }

    public boolean reset(){
        this.invalidate();
        init();
        return true;
    }

    public void actualizenumber(char c){
        if (c == '+')
            number += 1;
        else
            number -= 1;
    }
}