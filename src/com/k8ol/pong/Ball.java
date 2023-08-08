package com.k8ol.pong;

import com.k8ol.paddle2D.impl.Engine;
import com.k8ol.paddle2D.impl.GameObject;
import com.k8ol.paddle2D.impl.utils.CollisionRect;
import com.k8ol.paddle2D.impl.utils.Time;
import com.k8ol.paddle2D.render.MeshBuilder;

public class Ball extends GameObject {
    public CollisionRect collider;
    public float velX = 15f;
    public float velY = 0.0f;

    public Ball(float x, float y, float width, float height) {
        super(x, y, width, height, MeshBuilder.rect(width, height));
        collider = new CollisionRect(x, y, width, height);
    }

    @Override
    public void update() {
        x += velX * Time.getDeltaTime() / Engine.getWidth();
        y += velY * Time.getDeltaTime() / Engine.getHeight();

        if (y <= -1.0f + width  || y >= 1.0f) {
            velY = -velY;
        }

        collider.update(x, y);
        if (collider.isCollidingX(Player.collider)) {
            velX = -velX;
            velY = -(Player.collider.getY() - collider.getY()) * 15f * (float)Time.getDeltaTime();
        } else if (collider.isCollidingX(Enemy.collider)) {
            velX = -velX;
            velY = -(Player.collider.getY() - collider.getY()) * 15f * (float)Time.getDeltaTime();
        }
    }
}
