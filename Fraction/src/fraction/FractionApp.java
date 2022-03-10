/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fraction;

import java.util.Scanner;

/**
 *
 * @author pavel
 */
public class FractionApp {

    public static void main(String[] args) {
        System.out.println("Kalkulátor zlomků");
        Scanner sc = new Scanner(System.in);

        boolean end = false;
        String expression;
        do {
            System.out.println("Zadejte výraz se zlomky:");
            expression = sc.nextLine();

            System.out.println(Evaluator.evaluate(expression));

            System.out.println("Chcete pokračovat? (y/n)");
            end = sc.nextLine().toLowerCase().charAt(0) != 'y';

        } while (!end);

    }
}
