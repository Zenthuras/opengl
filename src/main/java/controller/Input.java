package controller;

import org.lwjgl.glfw.*;

public class Input {
    private static final boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    private static final boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private static double mouseX, mouseY;
    private static double scrollX, scrollY;

    private final GLFWKeyCallback keyboard;
    private final GLFWCursorPosCallback mouseMove;
    private final GLFWMouseButtonCallback mouseButtons;
    private final GLFWScrollCallback mouseScroll;

    public Input() {
        keyboard = new GLFWKeyCallback() {
            public void invoke(long window, int key, int scancode, int action, int mods) {
                keys[key] = (action != GLFW.GLFW_RELEASE);
            }
        };

        mouseMove = new GLFWCursorPosCallback() {
            public void invoke(long window, double xpos, double ypos) {
                mouseX = xpos;
                mouseY = ypos;
            }
        };

        mouseButtons = new GLFWMouseButtonCallback() {
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action != GLFW.GLFW_RELEASE);
            }
        };

        mouseScroll = new GLFWScrollCallback() {
            public void invoke(long window, double offsetx, double offsety) {
                scrollX += offsetx;
                scrollY += offsety;
            }
        };
    }

    public static boolean isKeyDown(int key) {
        return keys[key];
    }

    public static boolean isButtonDown(int button) {
        return buttons[button];
    }

    public void destroy() {
        keyboard.free();
        mouseMove.free();
        mouseButtons.free();
        mouseScroll.free();
    }

    public static boolean[] getKeys() {
        return keys;
    }

    public static boolean[] getButtons() {
        return buttons;
    }

    public static double getMouseX() {
        return mouseX;
    }

    public static void setMouseX(double mouseX) {
        Input.mouseX = mouseX;
    }

    public static double getMouseY() {
        return mouseY;
    }

    public static void setMouseY(double mouseY) {
        Input.mouseY = mouseY;
    }

    public static double getScrollX() {
        return scrollX;
    }

    public static void setScrollX(double scrollX) {
        Input.scrollX = scrollX;
    }

    public static double getScrollY() {
        return scrollY;
    }

    public static void setScrollY(double scrollY) {
        Input.scrollY = scrollY;
    }

    public GLFWKeyCallback getKeyboard() {
        return keyboard;
    }

    public GLFWCursorPosCallback getMouseMove() {
        return mouseMove;
    }

    public GLFWMouseButtonCallback getMouseButtons() {
        return mouseButtons;
    }

    public GLFWScrollCallback getMouseScroll() {
        return mouseScroll;
    }
}
