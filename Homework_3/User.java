package Homework_3;

import java.io.File;
import RequestExceptions;
import Homework_3.RequestExceptions.ParseException;

public class User {

    private Name userName;
    private BirthDay bday;
    private PhoneNumber phone;
    private char sex;

    public User() {this.userName = null;}

    public static String[] getData(String data) throws ParseException{
        String[] parsed = data.split(" ");
        if (parsed.length != 6) throw new RequestExceptions.ParseException();
        else return parsed;
    }

    public User(String[] data) {
        this.userName = new Name(data[0], data[1], data[2]);
        this.bday = new BirthDay(data[3]);
        this.phone = new PhoneNumber(data[4]);
        this.sex = data[5].charAt(0);
    }

    /**
     * Name
     */
    public class Name {

        private String regex = "^[A-Z][a-z]+$";
        private String firstName;
        private String lastName;
        private String surName;

        private Name(String fname, String lname, String sname) {
            this.firstName = fname;
            this.lastName = lname;
            this.surName = sname;
        }

        private boolean isCorrect() {
            return (this.firstName.matches(regex)
                && this.lastName.matches(regex)
                && this.surName.matches(regex));
        }
    }

    /**
     * Birth Day - string format: 'dd.mm.yyyy'.
     */
    public class BirthDay {

        String regex = "^(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19|20)\\d\\d$";
        private String date;

        private BirthDay(String date) {
            this.date = date;
        }

        private boolean isCorrect() {
            return this.date.matches(regex);
        }
    }

    public class PhoneNumber {

        private String regex = "^\\d{2}.\\d{2}.\\d{4}$";
        private String number;

        private PhoneNumber(String number) {
            this.number = number;
        }

        private boolean isCorrect() {
            return number.matches(regex);
        }
    }
}
