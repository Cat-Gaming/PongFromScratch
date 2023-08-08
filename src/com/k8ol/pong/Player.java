package com.k8ol.pong;

import com.k8ol.paddle2D.impl.Engine;
import com.k8ol.paddle2D.impl.GameObject;
import com.k8ol.paddle2D.impl.utils.CollisionRect;
import com.k8ol.paddle2D.impl.utils.Time;
import com.k8ol.paddle2D.render.Input;
import com.k8ol.paddle2D.render.MeshBuilder;
import org.lwjgl.glfw.GLFW;

public class Player extends GameObject {
    public static CollisionRect collider;
    public static final float MOVE_SPEED = 20f;
    public Player(float x, float y, float width, float height) {
        super(x, y, width, height, MeshBuilder.rect(width, height));
        collider = new CollisionRect(x, y, width, height);
    }

    @Override
    public void update() {
        if (Input.getKeyDown(GLFW.GLFW_KEY_W)) {
            y += MOVE_SPEED * Time.getDeltaTime() / Engine.getHeight();
            collider.update(x, y);
        } else if (Input.getKeyDown(GLFW.GLFW_KEY_S)) {
            y += -MOVE_SPEED * Time.getDeltaTime() / Engine.getHeight();
            collider.update(x, y);
        }

        // Out of bounds detection
        if (y - height < -1.0f) {
            y = -1.0f + height;
        } else if (y + height > 1.0f) {
            y = 1.0f - height;
        }
    }
}
