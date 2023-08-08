package com.k8ol.paddle2D.impl.utils;

import com.k8ol.paddle2D.impl.Engine;

import java.awt.*;

public class CollisionRect {
    private float x, y, width, height;
    public CollisionRect(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Some collision code I totally didn't copy off of stackoverflow
    // Source: https://stackoverflow.com/questions/31022269/collision-detection-between-two-rectangles-in-java
    // Checks if colliding on X axis I think
    public boolean isCollidingX(CollisionRect other) {
        float offW = (float)Engine.getWidth() / 2;
        float offH = (float)Engine.getHeight()/ 2;
        Rectangle a = new Rectangle((int) (x * Engine.getWidth()), (int) (y * Engine.getHeight()), (int) (width * Engine.getWidth()), (int) (height * Engine.getHeight()));
        Rectangle b = new Rectangle((int) (other.x * Engine.getWidth()), (int) (y * Engine.getHeight()), (int) (width * Engine.getWidth()), (int) (height * Engine.getHeight()));
        return a.intersects(b);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
