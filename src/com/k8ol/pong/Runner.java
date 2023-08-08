package com.k8ol.pong;

import com.k8ol.paddle2D.impl.Engine;

public class Runner {
    public static void main(String[] args) {
        Engine engine = new Engine(new PongGame(), 640, 480);
        engine.run();
    }
}
