package com.k8ol.paddle2D.impl;

import com.k8ol.paddle2D.render.Mesh;
import org.lwjgl.opengl.GL33;

public abstract class GameObject {
    // TODO: Fix World coordinates to be screen coordinates ex (800x600) because this is really hard to deal with -1.0 and 1.0 for x and y
    protected float x, y, width, height;
    private Mesh mesh;

    public GameObject(float x, float y, float width, float height, Mesh mesh) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mesh = mesh;
    }

    public abstract void update();
    public void render() {
        GL33.glPushMatrix();
        GL33.glTranslatef(x, y, 0);
        mesh.draw();
        GL33.glPopMatrix();
    }

    public void destroy() {
        mesh.destroy();
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
