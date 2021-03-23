package matrixTools.algorithm;

import matrixTools.algorithm.MatrixTransformer;

public class DeterminantCounter {
    private final MatrixTransformer matrixTransformer;

    public DeterminantCounter(MatrixTransformer matrixTransformer){
        this.matrixTransformer = matrixTransformer;
    }

    public double countDeterminantOfTriangleMatrix(double[][] matrix){
        double result=1;

        for (int i=0; i<matrix.length; i++){
            result *= matrix[i][i];
        }
        System.out.println(matrixTransformer.isDetChanged());

        if (matrixTransformer.isDetChanged()%2 >0){
            result = -1*result;
        }

        return result;
    }

    public double countDeterminantOfAnyMatrix(double[][] matrix){
        matrix = matrixTransformer.transformMatrix(matrix);
        if (matrix!=null){
            return countDeterminantOfTriangleMatrix(matrix);
        }else{
            return 0;
        }

    }
}
