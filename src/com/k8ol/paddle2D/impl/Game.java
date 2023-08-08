package com.k8ol.paddle2D.impl;

public abstract class Game {
    protected String title;
    public Game(String title) {
        this.title = title;
    }

    public abstract void init();
    public abstract void destroy();

    public abstract void update();
    public abstract void render();
}