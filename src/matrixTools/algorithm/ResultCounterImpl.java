package matrixTools.algorithm;

public class ResultCounterImpl implements ResultCounter {
    double[] result;
    MatrixTransformer matrixTransformer;

    public ResultCounterImpl(MatrixTransformer matrixTransformer){
        this.matrixTransformer=matrixTransformer;
    }

    @Override
    public double[] count(double[][] matrix) {
        result = new double[matrix.length];
        double[][] indexes = matrixTransformer.getIndexes();
        for (int i = matrix.length - 1; i>=0; i--) {
            for (int j = matrix.length - 1; j > i; j--) {
                matrix[i][matrix.length] -= matrix[i][j] * result[(int) indexes[i][j]];
            }
            result[(int) indexes[i][i]] = matrix[i][matrix.length]/matrix[i][i];
        }

        return result;
    }
}
