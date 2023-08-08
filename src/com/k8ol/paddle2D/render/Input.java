package com.k8ol.paddle2D.render;

import org.lwjgl.glfw.GLFW;

public class Input {
    private static long window;

    public static void init(long window) {
        Input.window = window;
    }

    public static boolean getKey(int key) {
        int state = GLFW.glfwGetKey(window, key);
        return state != GLFW.GLFW_RELEASE;
    }

    public static boolean getKeyDown(int key) {
        int state = GLFW.glfwGetKey(window, key);
        return state == GLFW.GLFW_PRESS;
    }

    public static boolean getKeyUp(int key) {
        int state = GLFW.glfwGetKey(window, key);
        return state == GLFW.GLFW_RELEASE;
    }
}
