package matrixTools.algorithm;

import org.jetbrains.annotations.NotNull;

public interface MatrixService {
    public double[][] swapCols(double[][] matrix, int row, int ind);
    public int findGreatest(double @NotNull [] row);
}
