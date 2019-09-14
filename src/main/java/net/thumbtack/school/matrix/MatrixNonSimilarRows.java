package net.thumbtack.school.matrix;

import java.util.*;
import java.util.stream.Collectors;

public class MatrixNonSimilarRows {
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> mapRows = new HashMap<>();
        for (int[] row : matrix) {
            Set<Integer> setKey = Arrays.stream(row).boxed().collect(Collectors.toSet());
            mapRows.putIfAbsent(setKey, row);
        }
        return new HashSet<>(mapRows.values());
    }
}
