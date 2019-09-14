package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Rectangle extends Figure {

    private Point2D topLeft, bottomRight;

    public Rectangle(Point2D leftTop, Point2D rightBottom, Color color) throws ColorException {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
        setColor(color);
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    public Rectangle(int length, int width, Color color) throws ColorException {
        this(0, -width, length, 0, color);
    }

    public Rectangle(Color color) throws ColorException {
        this(0, -1, 1, 0, color);
    }

    public Rectangle(Point2D leftTop, Point2D rightBottom, String color) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(color));
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(color));
    }

    public Rectangle(int length, int width, String color) throws ColorException {
        this(0, -width, length, 0, color);
    }

    public Rectangle(String color) throws ColorException {
        this(0, -1, 1, 0, color);
    }

    public Point2D getTopLeft() {
        return topLeft;
    }


    public Point2D getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point2D topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        bottomRight.moveTo(getLength() * nx + topLeft.getX(),
                getWidth() * ny + topLeft.getY());
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean isInside(int x, int y) {
        return topLeft.getX() <= x &&
                topLeft.getY() <= y &&
                bottomRight.getX() >= x &&
                bottomRight.getY() >= y;
    }


    public boolean isIntersects(Rectangle rectangle) {
        return topLeft.getX() <= rectangle.bottomRight.getX() &&
                topLeft.getY() <= rectangle.bottomRight.getY() &&
                bottomRight.getX() >= rectangle.topLeft.getX() &&
                bottomRight.getY() >= rectangle.topLeft.getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.topLeft) && isInside(rectangle.bottomRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topLeft, bottomRight);
    }
/*
    @Override
    public String toString() {
        return "RECTANGLE [" +
                "xLeft= " + topLeft.getX() +
                " yTop= " + topLeft.getY() +
                " xRight= " + bottomRight.getX() +
                " yBottom= " + bottomRight.getY() +
                " Color= " + color + "]";
    }*/
}
