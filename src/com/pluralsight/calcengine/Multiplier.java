package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase {

    @Override
    public String getKeyword() {
        return "multiply";
    }

    @Override
    public char getSymbol() {
        return '*';
    }

    public Multiplier() {
    }

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }
}
