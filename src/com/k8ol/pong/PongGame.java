package com.k8ol.pong;

import com.k8ol.paddle2D.impl.Engine;
import com.k8ol.paddle2D.impl.Game;
import com.k8ol.paddle2D.render.Input;
import org.lwjgl.glfw.GLFW;

public class PongGame extends Game {
    public static final String TITLE = "Pong";
    public PongGame() {
        super(TITLE);
    }

    Player player;
    Ball ball;
    Enemy enemy;

    @Override
    public void init() {
        ball = new Ball(0, 0, 0.05f, 0.05f);
        player = new Player(-0.8f, 0, 0.05f, 0.5f);
        enemy = new Enemy(0.8f, 0, 0.05f, 0.5f);
    }

    @Override
    public void update() {
        if (Input.getKey(GLFW.GLFW_KEY_ESCAPE)) {
            Engine.quit();
        }
        player.update();
        enemy.update(ball);
        ball.update();
    }

    @Override
    public void render() {
        player.render();
        enemy.render();
        ball.render();
    }

    @Override
    public void destroy() {
        player.destroy();
        enemy.destroy();
        ball.destroy();
    }
}
