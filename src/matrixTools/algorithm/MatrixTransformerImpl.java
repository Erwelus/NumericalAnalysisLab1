package matrixTools.algorithm;

import matrixTools.output.MatrixPrinter;

public class MatrixTransformerImpl implements MatrixTransformer {
    private int detChanged=0;
    private final MatrixService matrixService;
    private double[][] indexes;
    private MatrixPrinter printer;

    public MatrixTransformerImpl(MatrixService matrixService, MatrixPrinter printer){
        this.printer=printer;
        this.matrixService=matrixService;
    }

    public double[][] transformMatrix(double[][] matrix){
        int ind;
        double multiplier;
        fulfillIndexes(matrix.length);
        for (int i=0; i<matrix.length-1; i++){
            ind = matrixService.findGreatest(matrix[i]);
            if (ind > i){
                matrixService.swapCols(matrix, i, ind);
                matrixService.swapCols(indexes, i, ind);
                detChanged++;
            }
            if (matrix[i][i]==0){
                return null;
            }
            for (int j = i+1; j < matrix.length; j++) {
                multiplier = matrix[j][i]/matrix[i][i];
                for (int k = i; k < matrix.length+1; k++) {
                    matrix[j][k] -= matrix[i][k]*multiplier;
                }
            }
            printer.printMatrix(matrix);
        }

        return matrix;
    }

    private void fulfillIndexes(int length){
        indexes = new double[length][length+1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                indexes[i][j] = j;
            }
        }
    }

    @Override
    public double[][] getIndexes() {
        return indexes;
    }

    @Override
    public int isDetChanged() {
        return detChanged;
    }
}
