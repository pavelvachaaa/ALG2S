/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import java.util.Scanner;

/**
 *
 * @author pavli
 */
public final class InputUtils {

    private InputUtils() {

    }

    public static int readInt(String inputText, Scanner sc) {
        while (true) {
            System.out.print(inputText);
            if (!sc.hasNextInt()) {
                System.out.println("Zadal jste neplatný vstup!");
                sc.next();
                continue;
            }
            break;
        }
        return sc.nextInt();
    }

    public static int readInt(Scanner sc) {
        return readInt("", sc);
    }

    public static String readString(String inputText, Scanner sc) {
        while (true) {
            System.out.print(inputText);
            if (!sc.hasNextLine()) {
                System.out.println("Zadal jste neplatný vstup!");
                sc.next();
                continue;
            }
            break;
        }
        return sc.nextLine();
    }

    public static String readString(Scanner sc) {
        return readString("", sc);
    }

}
