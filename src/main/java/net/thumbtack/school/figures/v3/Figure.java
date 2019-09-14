package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;

import java.util.Objects;

public abstract class Figure implements Colored, HasArea {

    Color color;

    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    public Color getColor() {
        return color;
    }

    abstract public void moveRel(int dx, int dy);

    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
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
