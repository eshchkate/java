package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Cylinder extends Circle {

    private int height;


    public Cylinder(Point2D center, int radius, int height, int color) {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, int color) {
        super(xCenter, yCenter, radius, color);
        this.height = height;
    }

    public Cylinder(int radius, int height, int color) {
        this(0,0,radius, height, color);
    }

    public Cylinder(int color) {
        this(0,0,1, 1, color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea()*getHeight();
    }

    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y) &&  z>=0 && z <= this.getHeight();
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(),point.getY(),point.getZ());
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
