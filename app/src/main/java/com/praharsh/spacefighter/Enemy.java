package com.praharsh.spacefighter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Enemy {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 1;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    //creating a rect object
    private Rect detectCollision;

    public Enemy(Context context, int screenX, int screenY) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = generator.nextInt(20) + 15;
        x = screenX;
        y = generator.nextInt(maxY - this.bitmap.getHeight());
        //initializing rect object
        detectCollision = new Rect(x, y, this.bitmap.getWidth(), this.bitmap.getHeight());
    }

    public void update(int score) {
        x -= speed;
        if (x < minX - this.bitmap.getWidth()) {
            Random generator = new Random();
            speed = generator.nextInt(20) +15 + (int)(score/50);
            x = maxX;
            y = generator.nextInt(maxY - this.bitmap.getHeight());
        }
        //Adding the top, left, bottom and right to the rect object
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
    }

    //adding a setter to x coordinate so that we can change it after collision
    public void setX(int x) {
        this.x = x;
    }

    //one more getter for getting the rect object
    public Rect getDetectCollision() {
        return detectCollision;
    }

    //getters
    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getbitmapWidth(){return this.bitmap.getWidth();}

    public int getSpeed() {
        return speed;
    }
}