package model.geometry.Transforms;

import model.geometry.objects.Point;

import java.util.List;

public class Scale {
    private List<Point> points;

    public Scale(List<Point> points) {
        this.points = points;
    }

    public void scale(double d) {
        for (Point point : points) {
            double x = point.getX();
            double y = point.getY();
            double z = point.getZ();

            x *= d;
            y *= d;
            z *= d;

            point.setX(x);
            point.setY(y);
            point.setZ(z);
        }
    }

    public void scale(double d1, double d2, double d3) {
        for (Point point : points) {
            double x = point.getX();
            double y = point.getY();
            double z = point.getZ();

            x *= d1;
            y *= d2;
            z *= d3;

            point.setX(x);
            point.setY(y);
            point.setZ(z);
        }
    }
}
