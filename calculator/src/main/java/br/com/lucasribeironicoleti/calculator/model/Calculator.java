package br.com.lucasribeironicoleti.calculator.model;

public class Calculator {

    public static float sum(float n1, float n2) {
        return n1 + n2;
    }

    public static float sub(float n1, float n2) {
        return n1 - n2;
    }

    public static float mult(float n1, float n2) {
        return n1 * n2;
    }

    public static float div(float n1, float n2) {
        if(n2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return n1 / n2;
    }
}
