package matrixTools.algorithm;

public class ResidualsCounter {
    private double[][] matrix;

    public ResidualsCounter(double[][] matrix){
        this.matrix=new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length+1; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public double[] count(double[] results){
        double[] residuals = new double[results.length];
        for (int i = 0; i < results.length; i++) {
            residuals[i] = matrix[i][matrix.length];
            for (int j = 0; j < results.length; j++) {
                residuals[i]-=results[j]*matrix[i][j];
            }
        }
        return residuals;
    }

}
