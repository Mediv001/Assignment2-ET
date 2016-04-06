package com.example.english.assignment2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by english on 30/03/2016.
 */
public class Cells {
    int nb;
    boolean cover;
    Rect rectangle;
    Paint color;
    boolean mines;

    public boolean isMines() {
        return mines;
    }

    public void setMines(boolean mines) {
        this.mines = mines;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public Rect getXy() {
        return rectangle;
    }


    public boolean isCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public Cells(boolean cover, Rect a, Paint colour){
        this.cover = cover;
        nb = 0;
        rectangle = a;
        color = colour;
        setMines(false);
    }

    public void Draw(Canvas canvas){
        canvas.drawRect(rectangle.left, rectangle.top, rectangle.right, rectangle.bottom, getColor());
        if(!cover){
            if(isMines()) {
                Paint text = new Paint();
                text.setTextAlign(Paint.Align.CENTER);
                text.setTextSize(text.getTextSize() * 2);
                text.setColor(Color.BLACK);
                canvas.drawText("M", (getXy().left + getXy().right) / 2, (getXy().top + getXy().bottom) / 2, text);
            }else{
                Paint text = new Paint();
                text.setTextAlign(Paint.Align.CENTER);
                text.setTextSize(text.getTextSize() * 2);
                switch (getNb()){
                    case 0 :
                        break;
                    case 1 :
                        text.setColor(Color.BLUE);
                        canvas.drawText("1", (getXy().left + getXy().right) / 2, (getXy().top + getXy().bottom) / 2, text);
                        break;
                    case 2 :
                        text.setColor(0xFF00FF00);
                        canvas.drawText("2", (getXy().left + getXy().right) / 2, (getXy().top + getXy().bottom) / 2, text);
                        break;
                    case 3 :
                        text.setColor(0xFFFFFF00);
                        canvas.drawText("3", (getXy().left + getXy().right) / 2, (getXy().top + getXy().bottom) / 2, text);
                        break;
                    default:
                        text.setColor(0xFFFF0000);
                        canvas.drawText("" + getNb(), (getXy().left + getXy().right) / 2, (getXy().top + getXy().bottom) / 2, text);
                        break;
                }
            }
        }
    }
}