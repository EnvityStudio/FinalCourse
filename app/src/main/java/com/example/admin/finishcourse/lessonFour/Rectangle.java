package com.example.admin.finishcourse.lessonFour;


/**
 * @author Thuan Envity
 * @datetime 2018/1/3
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Rectangle {
    private static final String TAG = "Rectangle";
    private int width = 100;
    private int height = 50;
    private int color;

    private int x;
    private int y;
    private int boundWidth;
    private int boundHeight;
    private int step = 5;
    private Paint paint;
    private boolean isOver;

    public Rectangle(int color) {
        this.paint = new Paint();
        this.paint.setColor(color);
    }

    public void moveLeft() {
        if (this.x > step + this.width / 2) {
            this.x -= this.step;
            isOver = false;
            Log.d(TAG, "moveRight: x = " + this.x);
        } else {
            isOver = true;
            Log.d(TAG, "moveRight: ##x = " + this.x);
        }
    }

    public void moveRight() {
        if ((this.x + this.width / 2 + step) < this.boundWidth) {
            this.x += this.step;
            isOver = false;
            Log.d(TAG, "moveRight: x = " + this.x);
        } else {
            isOver = true;
            Log.d(TAG, "moveRight: ##x = " + this.x);
        }
    }

    public void setBounds(int boundWidth, int boundHeight) {
        this.boundHeight = boundHeight;
        this.boundWidth = boundWidth;
//        this.step = boundWidth / 20;
        x = boundWidth / 2;
        y = boundHeight / 2;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getBoundWidth() {
        return boundWidth;
    }

    public int getBoundHeight() {
        return boundHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void draw(Canvas canvas) {
        Log.d(TAG, "draw: rect");
        Log.d(TAG, "draw: new x " + x);
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        canvas.drawRect(new Rect(x - width / 2, y - height / 2, x + width / 2, y + height / 2), redPaint);

    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }
}
