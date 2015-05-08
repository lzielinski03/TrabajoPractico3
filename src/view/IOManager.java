package view;

import java.util.Scanner;

/**
 * Created by leonardo on 03/05/2015.
 */
public class IOManager {

    /* Deprecated
    protected void print(String message) {
        System.out.print(message);
    }*/

    /* Deprecated
    protected void print(int number) {
        System.out.print(number);
    }*/

    /* Deprecated
    protected void println(Object obj) {
        System.out.print(obj);
    }*/

    protected void println() {
        System.out.println();
    }

    protected void println(String message) {
        System.out.println(message);
    }

    /* Deprecated
    protected void println(int message) {
        System.out.println(message);
    }*/

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    protected String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        println(message);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }


}
