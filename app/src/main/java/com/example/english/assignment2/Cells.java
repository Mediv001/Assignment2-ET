package com.example.english.assignment2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by english on 30/03/2016.
 */
public class Cells {
    int nb;
    boolean cover;
    int[] xy = new int[4];
    Paint color;

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public int[] getXy() {
        return xy;
    }

    public void setXy(int[] xy) {
        this.xy = xy;
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

    public Cells(int nb, boolean cover, int[] a, Paint color){
        this.cover = cover;
        this.nb = nb;
        xy = a;
        this.color = color;
    }

    public void Draw(Canvas canvas){
        canvas.drawRect(xy[0],xy[1],xy[2],xy[3], this.getColor());
    }
}