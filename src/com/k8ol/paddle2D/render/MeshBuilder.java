package com.k8ol.paddle2D.render;

public class MeshBuilder {
    public static Mesh rect(float width, float height) {
        float[] vertices = {
                -width, -height,
                -width, height,
                width, -height,
                width, height
        };
        int[] indices = {
                0, 1, 2,
                2, 3, 1
        };
        return new Mesh(vertices, indices);
    }
}
