package matrixTools.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Greeter {
    private Scanner scanner;

    public Greeter(Scanner scanner){
        this.scanner=scanner;
    }

    public boolean greet(){
        System.out.println("Данная программа предназначена для решения СЛАУ методом Гаусса с выбором главного элемента по строке.");
        System.out.println("Чтобы ввести СЛАУ, предоставьте ее в матричном виде.");
        System.out.println("Сначала вводится количество переменных, затем на каждой строке указываются соответствующие коэффициенты.");
        System.out.println("Выберите формат ввода:\n");
        System.out.println("Ввод из консоли: [ 0 ]");
        System.out.println("Ввод из файла: [ 1 ]");

        int format;
        while (true){
            try {
                if (scanner.hasNext()) {
                    format = Integer.parseInt(scanner.next());
                    if (format<2){
                        break;
                    }else{
                        throw new Exception();
                    }
                }
            }catch (Exception e) {
                System.out.println("Пожалуйста, введите 0 или 1.");
            }
        }
        return format==0;
    }
}
