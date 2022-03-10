/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fraction;

/**
 *
 * @author pavel
 */
public class FractionTest {

    /**
     * Vrací true v případě správně vykonaného výrazu, jinak vyhazuje výjimku
     *
     * @param f
     * @param expected
     * @return
     * @throws RuntimeException
     */
    public static boolean equals(Fraction f, double expected) throws RuntimeException {
        if (f.valueOf() != expected) {
            throw new RuntimeException(String.format(" fVal(%.3f) %s != %.3f\n", f.valueOf(), f, expected
            ));
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Testy inicializace:");
        System.out.println(equals(new Fraction(1, 2), 0.5));
        System.out.println(equals(new Fraction(1, -2), -0.5));
        System.out.println(equals(new Fraction(-1, -2), 0.5));
        System.out.println(equals(new Fraction(-1, 2), -0.5));
        System.out.println(equals(new Fraction(0, 2), 0));
        System.out.println(equals(new Fraction(3), 3));

        System.out.println(equals(new Fraction(6, 2), 3));
        System.out.println(equals(new Fraction(2, 6), (1.0 / 3)));

        System.out.println(equals(FractionTools.substract(new Fraction(-1), new Fraction(-2)), 1));
        System.out.println(equals(FractionTools.substract(new Fraction(1), new Fraction(-2)), 3));
        System.out.println(equals(FractionTools.substract(new Fraction(1), new Fraction(2)), -1));

        System.out.println(equals(FractionTools.substract(new Fraction("-1"), new Fraction("-2")), 1));
        System.out.println(equals(FractionTools.substract(new Fraction("1"), new Fraction("-2")), 3));
        System.out.println(equals(FractionTools.substract(new Fraction("1"), new Fraction("2/2")), 0));

        System.out.println(equals(FractionTools.add(new Fraction("1"), new Fraction("2")), 3));

        System.out.println("Test ");

        System.out.println(new Fraction(""));
        System.out.println(new Fraction("1"));
        System.out.println(new Fraction("0"));
        System.out.println(new Fraction("1/3"));
        System.out.println(new Fraction("0/3"));
        System.out.println(new Fraction("  20 /  113"));
        System.out.println(new Fraction("  12 /  6"));

        System.out.println("");

        System.out.println(new Fraction("  -3 /  -6"));
        System.out.println(new Fraction("  3 /  -6"));
        System.out.println(new Fraction("  -3 /  6"));

        System.out.println("\nTesty výrazů:");

        // Mínusy jsou zlo
        System.out.println(equals(Evaluator.evaluate(" (-1)-(2)"), -3));
        System.out.println(equals(Evaluator.evaluate(" -1--2"), 1));
        System.out.println(equals(Evaluator.evaluate(" -2--1"), -1));
        System.out.println(equals(Evaluator.evaluate(" -1/2 + 1/2"), 0));
        System.out.println(equals(Evaluator.evaluate(" -1/2 + -1/-2"), 0));
        System.out.println(equals(Evaluator.evaluate(" 1/-2 - -1/-2"), -1));
        System.out.println(equals(Evaluator.evaluate(" 1/-2 - 1/-2"), 0));
        System.out.println(equals(Evaluator.evaluate(" 1/-2 + 1/-2"), -1));

        System.out.println(equals(Evaluator.evaluate(" 2:2 - -1:-1"), 0));
        System.out.println(equals(Evaluator.evaluate(" 2 - -1:-1"), 1));
        System.out.println(equals(Evaluator.evaluate(" -2 - 1/-1"), -1));

        System.out.println(equals(Evaluator.evaluate("(1/2 + 1/2):(1/2)"), 2));
        System.out.println(equals(Evaluator.evaluate("(1/2 + 1/2):(1/-2)"), -2));
        System.out.println(equals(Evaluator.evaluate("(1/2 + -1/2):(1/-2)"), 0));
        System.out.println(equals(Evaluator.evaluate("(1/2 + -1/2):1"), 0));

        System.out.println(equals(Evaluator.evaluate("(3/6 + -1/2):1"), 0));
        System.out.println(equals(Evaluator.evaluate("((3/6*1/2) + 1/2):1"), 3.0 / 4));
        System.out.println(equals(Evaluator.evaluate("-1*((1/2 + (1/4 : 1/4)) * 2/5 + 2/5) "), -1));

    }

}
