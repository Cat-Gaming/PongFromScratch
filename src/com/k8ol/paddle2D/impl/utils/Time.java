package com.k8ol.paddle2D.impl.utils;

public class Time {
    private static double delta;

    public static double getDeltaTime() {
        return delta;
    }

    public static void update(double delta) {
        Time.delta = delta;
    }
}
