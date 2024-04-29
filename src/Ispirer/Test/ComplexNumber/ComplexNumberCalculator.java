package Ispirer.Test.ComplexNumber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplexNumberCalculator extends JFrame {
    private JTextField realPart1Field, imaginaryPart1Field, realPart2Field, imaginaryPart2Field, resultField;

    public ComplexNumberCalculator() {
        setTitle("Complex Number Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label1 = new JLabel("Complex Number 1:");
        label1.setBounds(20, 20, 120, 20);
        add(label1);

        realPart1Field = new JTextField();
        realPart1Field.setBounds(150, 20, 50, 20);
        add(realPart1Field);

        JLabel plus1 = new JLabel("+");
        plus1.setBounds(210, 20, 20, 20);
        add(plus1);

        imaginaryPart1Field = new JTextField();
        imaginaryPart1Field.setBounds(240, 20, 50, 20);
        add(imaginaryPart1Field);

        JLabel i1 = new JLabel("i");
        i1.setBounds(300, 20, 20, 20);
        add(i1);

        JLabel label2 = new JLabel("Complex Number 2:");
        label2.setBounds(20, 60, 120, 20);
        add(label2);

        realPart2Field = new JTextField();
        realPart2Field.setBounds(150, 60, 50, 20);
        add(realPart2Field);

        JLabel plus2 = new JLabel("+");
        plus2.setBounds(210, 60, 20, 20);
        add(plus2);

        imaginaryPart2Field = new JTextField();
        imaginaryPart2Field.setBounds(240, 60, 50, 20);
        add(imaginaryPart2Field);

        JLabel i2 = new JLabel("i");
        i2.setBounds(300, 60, 20, 20);
        add(i2);

        JButton addButton = new JButton("Add");
        addButton.setBounds(150, 100, 80, 30);
        add(addButton);

        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBounds(250, 100, 80, 30);
        add(subtractButton);

        JButton multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(150, 140, 100, 30);
        add(multiplyButton);

        JButton divideButton = new JButton("Divide");
        divideButton.setBounds(270, 140, 80, 30);
        add(divideButton);

        resultField = new JTextField();
        resultField.setBounds(150, 150, 100, 20);
        resultField.setEditable(false);
        add(resultField);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComplexNumber complex1 = new ComplexNumber(Double.parseDouble(realPart1Field.getText()), Double.parseDouble(imaginaryPart1Field.getText()));
                ComplexNumber complex2 = new ComplexNumber(Double.parseDouble(realPart2Field.getText()), Double.parseDouble(imaginaryPart2Field.getText()));
                ComplexNumber sum = complex1.add(complex2);
                resultField.setText(sum.toString());
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComplexNumber complex1 = new ComplexNumber(Double.parseDouble(realPart1Field.getText()), Double.parseDouble(imaginaryPart1Field.getText()));
                ComplexNumber complex2 = new ComplexNumber(Double.parseDouble(realPart2Field.getText()), Double.parseDouble(imaginaryPart2Field.getText()));
                ComplexNumber difference = complex1.subtract(complex2);
                resultField.setText(difference.toString());
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComplexNumber complex1 = new ComplexNumber(Double.parseDouble(realPart1Field.getText()), Double.parseDouble(imaginaryPart1Field.getText()));
                ComplexNumber complex2 = new ComplexNumber(Double.parseDouble(realPart2Field.getText()), Double.parseDouble(imaginaryPart2Field.getText()));
                ComplexNumber product = complex1.multiply(complex2);
                resultField.setText(product.toString());
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComplexNumber complex1 = new ComplexNumber(Double.parseDouble(realPart1Field.getText()), Double.parseDouble(imaginaryPart1Field.getText()));
                ComplexNumber complex2 = new ComplexNumber(Double.parseDouble(realPart2Field.getText()), Double.parseDouble(imaginaryPart2Field.getText()));
                ComplexNumber division = complex1.divide(complex2);
                resultField.setText(division.toString());
            }
        });
    }

    public static void main(String[] args) {
        ComplexNumberCalculator calculator = new ComplexNumberCalculator();
        calculator.setVisible(true);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double realPart = this.real + other.real;
        double imaginaryPart = this.imaginary + other.imaginary;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double realPart = this.real - other.real;
        double imaginaryPart = this.imaginary - other.imaginary;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double divisor = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / divisor;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / divisor;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
