package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {

    private T figure1;
    private V figure2;

    public PairBox(T figure1, V figure2) {
        super();
        this.figure1 = figure1;
        this.figure2 = figure2;
    }

    public T getFigure1() {
        return figure1;
    }

    public void setFigure1(T figure1) {
        this.figure1 = figure1;
    }

    public V getFigure2() {
        return figure2;
    }

    public void setFigure2(V figure2) {
        this.figure2 = figure2;
    }

    @Override
    public double getArea() {
        return figure1.getArea() + figure2.getArea();
    }

    public boolean isAreaEqual(PairBox<?, ?> pairBox) {
        return this.getArea() == pairBox.getArea();
    }

    public static boolean isAreaEqual(PairBox<?, ?> pairBox1, PairBox<?, ?> pairBox2) {
        return pairBox1.getArea() == pairBox2.getArea();
    }

}
