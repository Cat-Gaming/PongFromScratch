package com.k8ol.paddle2D.impl;

import com.k8ol.paddle2D.impl.utils.Time;
import com.k8ol.paddle2D.render.Display;
import com.k8ol.paddle2D.render.Input;
import org.lwjgl.opengl.GL11;

public class Engine implements Runnable {
    private Game game;
    private static int width;
    private static int height;
    private static boolean running;

    public Engine(Game game, int window_width, int window_height) {
        this.game = game;
        width = window_width;
        height = window_height;
        running = false;
    }

    @Override
    public void run() {
        init();
        gameLoop();
        stop();
    }
    private void init() {
        Display.create(width, height, game.title);
        Input.init(Display.getWindowID());
        game.init();
    }
    private void stop() {
        game.destroy();
        Display.destroy();
    }

    public void update(double delta) {
        running = !Display.shouldClose();
        game.update();
        Time.update(delta);
    }

    public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        game.render();
        Display.update();
    }

    public void gameLoop() {
        running = true;
        long lastime = System.nanoTime();
        double AmountOfTicks = 60.0;
        double ns = 1000000000 / AmountOfTicks;
        double delta = 0;
        int frames = 0;
        double time = System.currentTimeMillis();

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastime) / ns;
            lastime = now;

            if(delta >= 1) {
                update(delta);
                render();
                frames++;
                delta -= 1;
                if(System.currentTimeMillis() - time >= 1000) {
                    System.out.println("fps:" + frames);
                    time += 1000;
                    frames = 0;
                }
            }
        }
    }

    public static void quit() {
        running = false;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
