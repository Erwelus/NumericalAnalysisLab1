package matrixTools.algorithm;

import matrixTools.algorithm.MatrixService;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.abs;

public class MatrixServiceImpl implements MatrixService {

    public double[][] swapCols(double[][] matrix, int row, int ind){
        double tmp;
        for (int i = row; i < matrix.length; i++) {
            tmp = matrix[i][row];
            matrix[i][row] = matrix[i][ind];
            matrix[i][ind] = tmp;
        }
        return matrix;
    }

    //returns the index of the greatest coefficient
    public int findGreatest(double @NotNull [] row){
        int ind=-1;
        for (int i = 0; i < row.length-1; i++) {
            if (ind<0 || abs(row[i]) > abs(row[ind])){
                ind = i;
            }
        }
        return ind;
    }
}
