package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point2D topLeft, bottomRight;

    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point2D(xLeft, yTop);
        this.bottomRight = new Point2D(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(0,-1,1,0);
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
        return bottomRight.getX()-topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY()-topLeft.getY();
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx,dy);
        bottomRight.moveRel(dx,dy);
    }

    public void enlarge(int nx, int ny) {
        bottomRight.moveTo(getLength()*nx+topLeft.getX(),
                                getWidth()*ny+topLeft.getY());
    }

    public double getArea() {
        return getLength()*getWidth();
    }

    public double getPerimeter() {
        return 2*(getLength()+getWidth());
    }

    public boolean isInside(int x, int y) {
        return  topLeft.getX() <= x &&
                 topLeft.getY() <= y &&
                 bottomRight.getX() >=x &&
                 bottomRight.getY() >=y;
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return topLeft.getX() <= rectangle.bottomRight.getX() &&
                topLeft.getY()<= rectangle.bottomRight.getY() &&
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
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
