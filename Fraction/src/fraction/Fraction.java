/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fraction;

/**
 *
 * @author pavel
 */
public class Fraction {

    private int numerator, denominator;

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) {

        this.numerator = numerator;
        this.denominator = checkDenominator(denominator);

        this.reduce();
    }

    public static int checkDenominator(int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmí být nulový");
        }

        return denominator;

    }

    public Fraction(String fraction) {

        //if (fraction.isBlank()) { stará java je pain
            if (fraction.isEmpty()) {
            this.numerator = 0;
            this.denominator = 1;
            return;
        }

        String[] tokens;

        if (fraction.contains("/")) {
            tokens = fraction.replaceAll("\\s+", "").split("/");
        } else {
            // Zbytečný mezery + mezery zleva
            tokens = fraction.replaceAll("\\s+", " ").replaceAll("^\\s+", "").split(" ");
        }

        if (tokens.length > 1) {
            this.denominator = checkDenominator(Integer.parseInt(tokens[1]));
        } else {
            this.denominator = 1;
        }

        this.numerator = Integer.parseInt(tokens[0]);

        this.reduce();
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    private void reduce() {
        int common = MathTools.gcd(this.numerator, this.denominator);
        this.numerator /= common;
        this.denominator /= common;
    }

    public double valueOf() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return String.format("%d", this.numerator);
        }

        if (this.denominator < 0) {
            return String.format("%d/%d", -this.numerator, -this.denominator);
        }

        return String.format("%d/%d", this.numerator, this.denominator);
    }

}
