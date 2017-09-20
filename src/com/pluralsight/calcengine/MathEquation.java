package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;

    public double getResult() {
        return result;
    }

    private double result;
    private char opcode = 'a';

    public MathEquation( char opcode) {
        this.opcode=opcode;
    }

    public MathEquation() {

    }

    public MathEquation( char opcode, double leftVal, double rightVal) {
        this(opcode);
        this.leftVal=leftVal;
        this.rightVal=rightVal;
    }

     public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    public void execute() {
        switch (opcode) {
            case 'a':

                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default :
                result = 0.0d;
            break;
        }
    }
}
