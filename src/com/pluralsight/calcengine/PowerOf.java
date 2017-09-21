package com.pluralsight.calcengine;

public class PowerOf extends CalculateBase  {
    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public void calculate() {
        double value= Math.pow(getLeftVal(), getRightVal());
        setResult(value);
    }
}
