package matrixTools.input;

import java.io.BufferedReader;
import java.io.IOException;

public class FileMatrixReader implements MatrixReader {
    private BufferedReader bufferedReader;

    public FileMatrixReader(BufferedReader bufferedReader){
        this.bufferedReader=bufferedReader;
    }

    @Override
    public double[][] readMatrix() {
        String[] buffer;
        double[][] matrix;
        try{
            String line = bufferedReader.readLine();
            int size = Integer.parseInt(line);
            matrix = new double[size][size+1];
            for (int i=0; i<size; i++){
                line = bufferedReader.readLine();
                buffer = line.split(" ");
                for (int j=0; j<size+1; j++){
                    matrix[i][j] = Double.parseDouble(buffer[j]);
                }
            }
        }catch (NumberFormatException|IOException ex){
            System.out.println("Некорректный файл");
            return null;
        }
        return matrix;
    }
}
