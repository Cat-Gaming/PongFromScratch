package com.k8ol.pong;

import com.k8ol.paddle2D.impl.GameObject;
import com.k8ol.paddle2D.impl.utils.CollisionRect;
import com.k8ol.paddle2D.impl.utils.Time;
import com.k8ol.paddle2D.render.MeshBuilder;

public class Enemy extends GameObject {
    public static CollisionRect collider;
    public Enemy(float x, float y, float width, float height) {
        super(x, y, width, height, MeshBuilder.rect(width, height));
        collider = new CollisionRect(x, y, width, height);
    }

    public void update(Ball ball) {
        float distanceY = ball.getY() - y;
        y += distanceY * Time.getDeltaTime();

        // Out of bounds detection
        if (y - height < -1.0f) {
            y = -1.0f + height;
        } else if (y + height > 1.0f) {
            y = 1.0f - height;
        }

        collider.update(x, y);
    }

    @Override
    public void update() {
    }
}
