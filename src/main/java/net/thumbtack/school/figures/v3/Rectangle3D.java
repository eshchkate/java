package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Rectangle3D extends Rectangle {

    private int height;

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, Color color) throws ColorException {
        super(leftTop, rightBottom, color);
        this.height = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom, color);
        this.height = height;
    }

    public Rectangle3D(int length, int width, int height, Color color) throws ColorException {
        super(length, width, color);
        this.height = height;
    }

    public Rectangle3D(Color color) throws ColorException {
        this(1, 1, 1, color);
    }

    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, String color) throws ColorException {
        super(leftTop, rightBottom, color);
        this.height = height;
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, String color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom, color);
        this.height = height;
    }

    public Rectangle3D(int length, int width, int height, String color) throws ColorException {
        super(length, width, color);
        this.height = height;
    }

    public Rectangle3D(String color) throws ColorException {
        this(1, 1, 1, color);
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

    public boolean isInside(Rectangle3D rectangle) {
        return (super.isInside(rectangle) && rectangle.height <= height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }

}
