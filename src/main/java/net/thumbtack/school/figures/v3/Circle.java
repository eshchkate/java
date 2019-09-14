package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Circle extends Figure {

    private Point2D center;

    private int radius;

    public Circle(Point2D center, int radius, Color color) throws ColorException {
        this.center = center;
        this.radius = radius;
        setColor(color);
    }

    public Circle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, color);

    }

    public Circle(int radius, Color color) throws ColorException {
        this(0, 0, radius, color);
    }

    public Circle(Color color) throws ColorException {
        this(0, 0, 1, color);
    }


    public Circle(Point2D center, int radius, String color) throws ColorException {
        this(center, radius, Color.colorFromString(color));
    }

    public Circle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        this(xCenter, yCenter, radius, Color.colorFromString(color));
    }

    public Circle(int radius, String color) throws ColorException {
        this(0, 0, radius, color);
    }

    public Circle(String color) throws ColorException {
        this(0, 0, 1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void enlarge(int n) {
        radius *= n;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        return Math.pow((x - center.getX()), 2) + Math.pow((y - center.getY()), 2) <= Math.pow(radius, 2);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius);
    }
}
