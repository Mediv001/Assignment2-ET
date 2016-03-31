package com.example.english.assignment2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by english on 30/03/2016.
 */
public class Cells {
    int nb;
    boolean cover;
    Rect rectangle;
    Paint color;

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

    public Cells(int nb, boolean cover, Rect a, Paint color){
        this.cover = cover;
        this.nb = nb;
        rectangle = a;
        this.color = color;
    }

    public void Draw(Canvas canvas){
        canvas.drawRect(rectangle.left, rectangle.top, rectangle.right, rectangle.bottom, getColor());
    }
}