package model.geometry.scene;

import controller.Input;
import model.geometry.topology.Vector3f;
import org.lwjgl.glfw.GLFW;

public class Camera {
    private Vector3f position, rotation;
    private float moveSpeed = 0.05f, mouseSensitivity = 0.15f, distance = 2.0f, horizontalAngle = 0, verticalAngle = 0;
    private double oldMouseX = 0, oldMouseY = 0, newMouseX, newMouseY;

    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public void update() {
        newMouseX = Input.getMouseX();
        newMouseY = Input.getMouseY();

        float x = (float) Math.sin(Math.toRadians(rotation.getY())) * moveSpeed;
        float z = (float) Math.cos(Math.toRadians(rotation.getY())) * moveSpeed;

        if (Input.isKeyDown(GLFW.GLFW_KEY_A)) position = Vector3f.add(position, new Vector3f(-z, 0, x));
        if (Input.isKeyDown(GLFW.GLFW_KEY_D)) position = Vector3f.add(position, new Vector3f(z, 0, -x));
        if (Input.isKeyDown(GLFW.GLFW_KEY_W)) position = Vector3f.add(position, new Vector3f(-x, 0, -z));
        if (Input.isKeyDown(GLFW.GLFW_KEY_S)) position = Vector3f.add(position, new Vector3f(x, 0, z));
        if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE)) position = Vector3f.add(position, new Vector3f(0, moveSpeed, 0));
        if (Input.isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT))
            position = Vector3f.add(position, new Vector3f(0, -moveSpeed, 0));

        float dx = (float) (newMouseX - oldMouseX);
        float dy = (float) (newMouseY - oldMouseY);

        rotation = Vector3f.add(rotation, new Vector3f(-dy * mouseSensitivity, -dx * mouseSensitivity, 0));

        oldMouseX = newMouseX;
        oldMouseY = newMouseY;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getMouseSensitivity() {
        return mouseSensitivity;
    }

    public void setMouseSensitivity(float mouseSensitivity) {
        this.mouseSensitivity = mouseSensitivity;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getHorizontalAngle() {
        return horizontalAngle;
    }

    public void setHorizontalAngle(float horizontalAngle) {
        this.horizontalAngle = horizontalAngle;
    }

    public float getVerticalAngle() {
        return verticalAngle;
    }

    public void setVerticalAngle(float verticalAngle) {
        this.verticalAngle = verticalAngle;
    }

    public double getOldMouseX() {
        return oldMouseX;
    }

    public void setOldMouseX(double oldMouseX) {
        this.oldMouseX = oldMouseX;
    }

    public double getOldMouseY() {
        return oldMouseY;
    }

    public void setOldMouseY(double oldMouseY) {
        this.oldMouseY = oldMouseY;
    }

    public double getNewMouseX() {
        return newMouseX;
    }

    public void setNewMouseX(double newMouseX) {
        this.newMouseX = newMouseX;
    }

    public double getNewMouseY() {
        return newMouseY;
    }

    public void setNewMouseY(double newMouseY) {
        this.newMouseY = newMouseY;
    }
}
