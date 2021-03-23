import matrixTools.algorithm.*;
import matrixTools.input.ConsoleMatrixReader;
import matrixTools.input.FileMatrixReader;
import matrixTools.input.Greeter;
import matrixTools.input.MatrixReader;
import matrixTools.output.MatrixPrinter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MatrixReader matrixReader;
        double[][] matrix;
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter(scanner);
        if(greeter.greet()){
            matrixReader = new ConsoleMatrixReader(new Scanner(System.in));
            matrix = matrixReader.readMatrix();
        }else{
            System.out.println("Введите имя файла");
            BufferedReader reader;
            while (true){
                try {
                    if (scanner.hasNext()) {
                        String filename = scanner.next();
                        reader = new BufferedReader(new FileReader(filename));
                        break;
                    }
                }catch (FileNotFoundException e) {
                    System.out.println("Файл не найден. Проверьте корректность написания имени файла.");
                }
            }
            matrixReader = new FileMatrixReader(reader);
            matrix = matrixReader.readMatrix();
            if (matrix==null){return;}
        }

        MatrixService matrixService = new MatrixServiceImpl();
        MatrixPrinter matrixPrinter = new MatrixPrinter();
        MatrixTransformer matrixTransformer = new MatrixTransformerImpl(matrixService, matrixPrinter);
        ResultCounter resultCounter = new ResultCounterImpl(matrixTransformer);
        DeterminantCounter determinantCounter = new DeterminantCounter(matrixTransformer);
        ResidualsCounter residualsCounter = new ResidualsCounter(matrix);

        //matrixTransformer.transformMatrix(matrix);
        double determinant = determinantCounter.countDeterminantOfAnyMatrix(matrix);

        if (determinant!=0 && !Double.isNaN(determinant)) {

            System.out.println("Определитель: "+determinant+"\n");
            System.out.println("Треугольная матрица:");
            matrixPrinter.printMatrix(matrix);

            double[] result = resultCounter.count(matrix);
            double[] residuals = residualsCounter.count(result);

            matrixPrinter.printArrayWithComments(result, "Результат", "x");
            matrixPrinter.printArrayWithComments(residuals, "Невязки", "r");

        }else{
            System.out.println("Матрица вырождена");
        }
    }
}