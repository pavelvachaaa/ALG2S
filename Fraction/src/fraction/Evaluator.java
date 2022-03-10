/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fraction;

import java.util.Stack;

/**
 *
 * @author pavel
 */
public class Evaluator {

    public static Fraction evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Hodnoty
        Stack<Fraction> values = new Stack<>();

        // Operandi
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            // Prázdný znaky přeskakujeme
            if (tokens[i] == ' ') {
                continue;
            }

            // Je tam číslo?
            if (tokens[i] >= '0' && tokens[i] <= '9' || (tokens[i] == '-' && (i < tokens.length && tokens[i + 1] >= '0' && tokens[i + 1] <= '9'))) {
                StringBuilder numeratorBuf = new StringBuilder();
                StringBuilder denumeratorBuf = new StringBuilder();

                if (tokens[i] == '-') {
                    numeratorBuf.append(tokens[i++]);
                }

                // Co když čísla pokračují?
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    numeratorBuf.append(tokens[i++]);
                }

                if (i < tokens.length && tokens[i] == '/') {
                    i++;
                    if (tokens[i] == '-') {
                        denumeratorBuf.append(tokens[i++]);
                    }
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                        denumeratorBuf.append(tokens[i++]);
                    }
                }

                if ("".equals(denumeratorBuf.toString())) {
                    denumeratorBuf.append('1');
                }

                values.push(new Fraction(Integer.parseInt(numeratorBuf.toString()), Integer.parseInt(denumeratorBuf.toString())));
                i--;

            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == ':') {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }

                // Operandi
                ops.push(tokens[i]);
            }

        }

        // Celý výraz byl vyhodnocen, poslední hodnoty..
        while (!ops.empty()) {
            char operand = ops.pop();
            values.push(applyOp(operand, values.pop(), values.pop()));
        }

        return values.pop();

    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }

        return !((op1 == '*' || op1 == ':') && (op2 == '+' || op2 == '-'));
    }

    private static Fraction applyOp(char op, Fraction f1, Fraction f2) {
        switch (op) {
            case '+':
                return FractionTools.add(f1, f2);
            case '-':
                return FractionTools.substract(f2, f1);
            case '*':
                return FractionTools.multiply(f1, f2);
            case ':':
                return FractionTools.divide(f2, f1);
        }
        return new Fraction(0);
    }
}
