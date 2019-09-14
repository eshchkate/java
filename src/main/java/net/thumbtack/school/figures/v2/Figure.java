package net.thumbtack.school.figures.v2;

import java.util.Objects;

public abstract class Figure implements Colored{

    int color;

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    abstract public void moveRel(int dx, int dy);

    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(),point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return color == figure.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color);
    }
}
