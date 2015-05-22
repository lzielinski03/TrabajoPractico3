package view;

import java.util.Scanner;

/**
 * Created by leonardo on 03/05/2015.
 */
public class IOManager {

    protected void println() {
        System.out.println();
    }

    protected void println(String message) {
        System.out.println(message);
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    protected String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        println(message);
        return scanner.nextLine();
    }
}