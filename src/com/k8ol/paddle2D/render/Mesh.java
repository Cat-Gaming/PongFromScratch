package com.k8ol.paddle2D.render;

import static org.lwjgl.opengl.GL33.*;

public class Mesh {
    private final int vao;
    private final int drawCount;

    public Mesh(float[] vertices, int[] indices) {
        drawCount = indices.length;
        int vbo = glGenBuffers();
        int ibo = glGenBuffers();
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        // VBO and IBO data stuff
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);
        // VAO attribute binding
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
        glDisableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public void draw() {
        glBindVertexArray(vao);
        glEnableVertexAttribArray(0);
        glDrawElements(GL_TRIANGLES, drawCount, GL_UNSIGNED_INT, 0L);
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);
    }

    public void destroy() {
        glBindVertexArray(0);
        glDeleteVertexArrays(vao);
    }
}
