package Lesson_3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Lesson_3.Exceptions.NotFound;

/**
 * Main
 */
public class Main {

    public static void doSomthing() throws IOException {
        throw new IOException();
    }
    public static void main(String[] args) throws NotFound {
        try {
            doSomthing();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        

        try (Counter counter = new Counter()) {
            System.out.println(counter);
            counter.close();
            counter.add();
            System.out.println(counter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Task 2
        // try {
        //     System.out.println(10 / 0);
        // } catch (ArithmeticException z) {
        //     throw new Exceptions.ZeroDiv(z.getMessage());
        // }
    
        // Task 3
        // Integer[] array = new Integer[5];
        // for (int i = 0; i < array.length; i++)
        //     if (array[i] == null) throw new Exceptions.NullPointer(i);
        //     else System.out.println(array[i]);

        // Task 4
        String file = "test.file";
        try (FileReader reader = new FileReader(file)){
        } catch (IOException e) {
            throw new Exceptions.NotFound(file);                
        }
    }
}