package model.geometry.scene;

import model.geometry.topology.Vector3f;

import java.util.List;

// Různé transformace těles
public class Transformer {
    private final List<Vector3f> points;

    public Transformer(List<Vector3f> points) {
        this.points = points;
    }

    public void scale(double d) {
        for (Vector3f vector3F : points) {
            double x = vector3F.getX();
            double y = vector3F.getY();
            double z = vector3F.getZ();

            x *= d;
            y *= d;
            z *= d;

            vector3F.setX(x);
            vector3F.setY(y);
            vector3F.setZ(z);
        }
    }

    public void scale(double d1, double d2, double d3) {
        for (Vector3f vector3F : points) {
            double x = vector3F.getX();
            double y = vector3F.getY();
            double z = vector3F.getZ();

            x *= d1;
            y *= d2;
            z *= d3;

            vector3F.setX(x);
            vector3F.setY(y);
            vector3F.setZ(z);
        }
    }
}
