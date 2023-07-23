package Lesson_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Main
 * Запишите в файл следующие строки
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * Реализуйте метод который считывает данные из файла и сохраняет в двумерный
 * массив. В отдельном методе нужно будет пройти по структуре данных если
 * сохранено значение ? - заменить его на число.
 */
public class Main {

    public static HashMap<String, Integer> getData(String path) {
        HashMap<String, Integer> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] splitedLine = line.split("=");
                if (splitedLine[1].equals("?"))
                    data.put(splitedLine[0], splitedLine[0].length());
                else data.put(splitedLine[0], Integer.parseInt(splitedLine[1]));
            }
            return data;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static boolean putData(HashMap<String, Integer> data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Map.Entry<String, Integer> entry: data.entrySet())
                writer.write(String.format("%s=%d\n", entry.getKey(), entry.getValue()));
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        String fileName = "/home/Maksim/GB3474/JavaException/Lesson_2/file";
        HashMap<String, Integer> dataSet = getData(fileName);
        if (dataSet != null) {
            if (putData(dataSet, fileName)) System.out.println("Done.");
            else System.out.println("Error.");
        }
    }
}