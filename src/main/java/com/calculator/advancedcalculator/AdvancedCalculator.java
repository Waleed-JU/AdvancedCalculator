package com.calculator.advancedcalculator;

import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Advanced Calculator ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /, %): ");
        char op = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;

        switch (op) {
            case '+':
                result = new Add().calculate(num1, num2);
                break;
            case '-':
                result = new Subtract().calculate(num1, num2);
                break;
            case '*':
                result = new Multiply().calculate(num1, num2);
                break;
            case '/':
                result = new Divide().calculate(num1, num2);
                break;
            case '%':
                result = new Modulus().calculate(num1, num2);
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }

        System.out.println("Result: " + result);
    }
}
