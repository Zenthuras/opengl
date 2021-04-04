package view;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private final String title;
    private long glfwWindow;
    private int width;
    private int height;
    private boolean resized;
    private boolean vSync;

    public Window(String title, int width, int height, boolean vSync) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.vSync = vSync;
    }

    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit())
            throw new IllegalStateException("Inicializace selhala!");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        glfwWindow = glfwCreateWindow(width, height, title, NULL, NULL);
        if (glfwWindow == NULL)
            throw new RuntimeException("Nepodařilo se vytvořit okno!");

        glfwSetFramebufferSizeCallback(glfwWindow, (window, width, height) -> {
            this.width = width;
            this.height = height;
            this.setResized(true);
        });

        glfwSetKeyCallback(glfwWindow, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true);
        });

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(
                glfwWindow,
                (videoMode.width() - width) / 2,
                (videoMode.height() - height) / 2
        );

        glfwMakeContextCurrent(glfwWindow);

        if (isVSync()) {
            glfwSwapInterval(1);
        }

        glfwShowWindow(glfwWindow);
    }

    public void update() {
        glfwSwapBuffers(glfwWindow);
        glfwPollEvents();
    }

    public long getGlfwWindow() {
        return glfwWindow;
    }

    public void setGlfwWindow(long glfwWindow) {
        this.glfwWindow = glfwWindow;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isResized() {
        return resized;
    }

    public void setResized(boolean resized) {
        this.resized = resized;
    }

    public boolean isVSync() {
        return vSync;
    }

    public void setVSync(boolean vSync) {
        this.vSync = vSync;
    }
}


