package Homework_2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    /*
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
     * (типа float), и возвращает введенное значение. Ввод текста вместо числа
     * не должно приводить к падению приложения, вместо этого, необходимо
     * повторно запросить у пользователя ввод данных.
     */
    public static float getFloat() {
        Float num = null;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (num == null) {
            try {
                System.out.println("Please enter float in next line.");
                num = Float.parseFloat(input.readLine());
            } catch(NumberFormatException | NullPointerException e) {
                System.err.println("Conversion error.");
            } catch(IOException e) {
                System.err.println("Read error.");
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getFloat());
    }
}
