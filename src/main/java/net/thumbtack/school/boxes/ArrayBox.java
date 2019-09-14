package net.thumbtack.school.boxes;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {

    private T[] figure;


    public ArrayBox(T[] figure) {
        this.figure = figure;
    }

    public T[] getContent() {
        return figure;
    }

    public void setContent(T[] figure) {
        this.figure = figure;
    }

    public T getElement(int e) {
        return figure[e];
    }

    public void setElement(int e, T f) {
        figure[e] = f;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> figureArrayBox) {
        return figure.length == figureArrayBox.getContent().length;

    }

}
