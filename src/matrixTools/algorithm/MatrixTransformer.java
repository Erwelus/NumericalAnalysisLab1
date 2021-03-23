package matrixTools.algorithm;

public interface MatrixTransformer {
    double[][] transformMatrix(double[][] matrix);
    double[][] getIndexes();
    int isDetChanged();
}
