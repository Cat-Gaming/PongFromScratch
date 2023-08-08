package com.k8ol.paddle2D.render;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import static org.lwjgl.system.MemoryUtil.NULL;

public class Display {
    private static long window;
    public static void create(int width, int height, String title) {
        if (!GLFW.glfwInit()) {
            System.err.println("GLFW failed to initialize!");
            new Exception().printStackTrace();
            System.exit(1);
        }
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
        window = GLFW.glfwCreateWindow(width, height, title, NULL, NULL);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwSwapInterval(0);
        GL.createCapabilities();
    }

    public static boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public static void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public static void destroy() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public static long getWindowID() {
        return window;
    }
}