package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Triangle extends Figure{

    private Point2D point1, point2, point3;

    public Triangle(Point2D point1, Point2D point2, Point2D point3, int color) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.color = color;
    }

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint1(Point2D point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point2D point2) {
        this.point2 = point2;
    }

    public void setPoint3(Point2D point3) {
        this.point3 = point3;
    }


    public double getSide12() {
        return Math.sqrt(Math.pow(point2.getX()-point1.getX(),2)+(Math.pow(point2.getY()-point1.getY(),2)));
    }

    public double getSide13() {
        return Math.sqrt(Math.pow(point3.getX()-point1.getX(),2)+(Math.pow(point3.getY()-point1.getY(),2)));
    }

    public double getSide23() {
        return Math.sqrt(Math.pow(point3.getX()-point2.getX(),2)+(Math.pow(point3.getY()-point2.getY(),2)));
    }

    @Override
    public void moveRel(int dx, int dy) {
        point1.moveRel(dx,dy);
        point2.moveRel(dx,dy);
        point3.moveRel(dx,dy);
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-getSide12())*(p-getSide13())*(p-getSide23()));
    }

    @Override
    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    @Override
    public boolean isInside(int x, int y) {
        int a = (point1.getX()-x)*(point2.getY()-point1.getY())-(point2.getX()-point1.getX())*(point1.getY()-y);
        int b = (point2.getX()-x)*(point3.getY()-point2.getY())-(point3.getX()-point2.getX())*(point2.getY()-y);
        int c = (point3.getX()-x)*(point1.getY()-point3.getY())-(point1.getX()-point3.getX())*(point3.getY()-y);
        return (a>=0 && b>=0 && c>=0) || (a<=0 && b<=0 && c<=0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), point1, point2, point3);
    }
}
