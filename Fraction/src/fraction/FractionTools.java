package fraction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pavel
 */
public class FractionTools {

    public static Fraction add(Fraction f1, Fraction f2) {
        int common = MathTools.lcm(f1.getDenominator(), f2.getDenominator());
        int sum = f1.getNumerator() * (common / f1.getDenominator()) + f2.getNumerator() * (common / f2.getDenominator());

        return new Fraction(sum, common);
    }

    public static Fraction substract(Fraction f1, Fraction f2) {
        int common = MathTools.lcm(f1.getDenominator(), f2.getDenominator());
        int sum = f1.getNumerator() * (common / f1.getDenominator()) - f2.getNumerator() * (common / f2.getDenominator());

        return new Fraction(sum, common);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(f1.getNumerator() * f2.getNumerator(), f2.getDenominator() * f1.getDenominator());
    }

    public static Fraction divide(Fraction f1, Fraction f2) {
        return new Fraction(f1.getNumerator() * f2.getDenominator(), f1.getDenominator() * f2.getNumerator());
    }

}
