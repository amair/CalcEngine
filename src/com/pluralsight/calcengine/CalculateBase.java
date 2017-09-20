package com.pluralsight.calcengine;

public abstract class CalculateBase {
    private double leftVal, rightVal, result;
    private char opcode = 'a';

    public double getRightVal() {
        return rightVal;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public void setOpcode(char opcode) {
        this.opcode = opcode;
    }

    public double getResult() {

        return result;
    }

    protected void setResult(double result) {
        this.result = result;
    }   public CalculateBase(){};

    public CalculateBase( double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public abstract void calculate();


}
