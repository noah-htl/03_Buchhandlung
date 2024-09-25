package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.spi.DateFormatProvider;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Buch> buecher = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Wollen Sie ein Buch ausleihen? ");
            String eingabe = scanner.nextLine();

            if(!eingabe.equalsIgnoreCase("ja")){
                continue;
            }

            System.out.print("Titel: ");
            String titel = scanner.nextLine();

            boolean repeat;
            ISBN10 isbn10 = null;

            do {
                repeat = false;
                System.out.print("ISBN-10: ");
                String _isbn = scanner.nextLine();

                try {
                    isbn10 = ISBN10.of(_isbn);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    repeat = true;
                }
            } while (repeat);

            System.out.print("Verlag: ");
            String verlag = scanner.nextLine();



            repeat = false;
            Date date = null;

            do {

                System.out.print("Erscheinungsdatum: ");
                String _datum = scanner.nextLine();
                try {
                    date = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.GERMAN).parse(_datum);
                } catch (ParseException e) {
                    repeat = true;
                    System.out.println(e.getMessage());
                }

            }while (repeat);

            buecher.add(new Buch(titel, verlag, isbn10, date));


            for(Buch buch : buecher){
                System.out.println(buch.csv());
            }
        }
    }
}