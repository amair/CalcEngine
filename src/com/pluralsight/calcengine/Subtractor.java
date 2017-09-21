package com.pluralsight.calcengine;

public class Subtractor extends CalculateBase {

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public char getSymbol() {
        return '-';
    }



    public Subtractor() {
    }

    public Subtractor(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }
}
