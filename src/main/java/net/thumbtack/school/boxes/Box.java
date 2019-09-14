package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class Box<T extends Figure> implements HasArea {
    private T figure;

    public Box(T figure) {
        super();
        this.figure = figure;
    }

    public T getContent() {
        return figure;
    }

    public void setContent(T figure) {
        this.figure = figure;
    }

    @Override
    public double getArea() {
        return figure.getArea();
    }

    public boolean isAreaEqual(Box<? extends Figure> figure) {
        return this.getArea() == figure.getArea();
    }

    public static boolean isAreaEqual(Box<? extends Figure> figure1, Box<?> figure2) {
        return figure1.getArea() == figure2.getArea();
    }

}
