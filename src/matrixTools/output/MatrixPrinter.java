package matrixTools.output;

public class MatrixPrinter {
    public void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != matrix.length) {
                    System.out.printf("%1$6.2f", matrix[i][j]);
                }else {
                    System.out.printf("%1$2s%2$6.2f", "|", matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printArray(double[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }

    public void printArrayWithComments(double[] array, String name, String element){
        System.out.println(name+": ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(element + (i + 1) + ": "+array[i]);
        }
        System.out.println();
    }
}
