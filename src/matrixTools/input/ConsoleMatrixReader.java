package matrixTools.input;

import java.util.Scanner;

public class ConsoleMatrixReader implements MatrixReader {
    private Scanner scanner;

    public ConsoleMatrixReader(Scanner scanner){
        this.scanner=scanner;
    }

    @Override
    public double[][] readMatrix() {
        double[][] matrix;
        int size;

        while (true){
            try {
                System.out.println("Введите число неизвестных: ");
                if (scanner.hasNext()) {
                    size = Integer.parseInt(scanner.next());
                    break;
                }
            }catch (Exception ex){
                System.out.println("Некорректный ввод. Следуйте указаниям.");
            }
        }
        matrix = new double[size][size+1];
        for (int i=0; i<size; i++){
            System.out.println("Введите коэффициенты, включая столбец B: ");
            for (int j=0; j<size+1; j++){
                try {
                    if (scanner.hasNext()){
                        matrix[i][j] = Double.parseDouble(scanner.next());
                    }
                }catch (Exception ex){
                    System.out.println("Некорректный ввод. Пожалуйста, вводите только числа.");
                    j--;
                }
            }
        }
        return matrix;
    }
}
