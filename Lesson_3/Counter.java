package Lesson_3;

import java.io.IOException;

public class Counter implements AutoCloseable{
//    Создайте класс Счетчик, у которого есть метод add(), увеличивающий
// значение внутреннейint переменнойна 1.Сделайте так, чтобы с объектом
// такого типа можно было работать в блоке try-with-resources. Нужно бросить
// исключение, еслиработа с объектом типа счетчикбылане в ресурсномtry
// и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
// лучше всего. 
    private Integer count;
    public Counter() {this.count = 0;}

    public void add() throws IOException {
        if (this.count == null) throw new IOException();
        else this.count++;
    }

    @Override
    public void close() throws IOException {
        this.count = null;
    }

    @Override
    public String toString() {
        return String.format("%d", this.count);
    }
}
