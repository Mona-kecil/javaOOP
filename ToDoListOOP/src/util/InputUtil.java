package util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + "\n>> ");
        String data = scanner.nextLine();
        return data;
    }
}