package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Cylinder extends Circle {

    private int height;


    public Cylinder(Point2D center, int radius, int height, Color color) throws ColorException {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, Color color) throws ColorException {
        super(xCenter, yCenter, radius, color);
        this.height = height;
    }

    public Cylinder(int radius, int height, Color color) throws ColorException {
        this(0, 0, radius, height, color);
    }

    public Cylinder(Color color) throws ColorException {
        super(color);
        this.height = 1;
    }

    public Cylinder(Point2D center, int radius, int height, String color) throws ColorException {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, String color) throws ColorException {
        super(xCenter, yCenter, radius, color);
        this.height = height;
    }

    public Cylinder(int radius, int height, String color) throws ColorException {
        this(0, 0, radius, height, color);
    }

    public Cylinder(String color) throws ColorException {
        super(color);
        this.height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * getHeight();
    }

    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y) && z >= 0 && z <= this.getHeight();
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return height == cylinder.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}
