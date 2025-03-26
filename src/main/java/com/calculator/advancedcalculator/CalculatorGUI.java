package com.calculator.advancedcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private JTextField number1Field, number2Field;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Advanced Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null); // Center window

        JLabel num1Label = new JLabel("Enter first number:");
        number1Field = new JTextField();

        JLabel num2Label = new JLabel("Enter second number:");
        number2Field = new JTextField();

        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);

        // Buttons for each operation
        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton mulBtn = new JButton("*");
        JButton divBtn = new JButton("/");
        JButton modBtn = new JButton("%");

        // Add action listeners
        addBtn.addActionListener(e -> calculate('+'));
        subBtn.addActionListener(e -> calculate('-'));
        mulBtn.addActionListener(e -> calculate('*'));
        divBtn.addActionListener(e -> calculate('/'));
        modBtn.addActionListener(e -> calculate('%'));

        // Add components to frame
        add(num1Label); add(number1Field);
        add(num2Label); add(number2Field);
        add(addBtn); add(subBtn);
        add(mulBtn); add(divBtn);
        add(modBtn); add(resultLabel);

        setVisible(true);
    }

    private void calculate(char op) {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double result = 0;

            switch (op) {
                case '+': result = new Add().calculate(num1, num2); break;
                case '-': result = new Subtract().calculate(num1, num2); break;
                case '*': result = new Multiply().calculate(num1, num2); break;
                case '/': result = new Divide().calculate(num1, num2); break;
                case '%': result = new Modulus().calculate(num1, num2); break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        } catch (ArithmeticException e) {
            resultLabel.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
    }
}
