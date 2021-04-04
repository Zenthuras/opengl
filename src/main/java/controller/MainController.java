package controller;

import model.render.Renderer;
import org.lwjgl.opengl.GL;
import view.Window;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.*;

public class MainController {
    private Window window;
    private Renderer renderer;

    public MainController() {
    }

    public void initController() {
        window = new Window("PGRF2 OpenGL - Liška", 800, 600, true);
        window.init();
        renderer = new Renderer();
        loop();
    }

    private void loop() {
        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        while (!glfwWindowShouldClose(getWindow().getGlfwWindow())) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            renderer.render();
            window.update();
        }
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
