package com.pluralsight.calcengine;

public class CalculateHelper {
    private static char ADD_SYMBOL ='+';
    private static char MINUS_SYBOL='-';
    private static char DIVIDE_SYMBOL='/';
    private static char MULTIPLY_SYMBOL='*';

    MathCommand command;
    double leftValue, rightValue, result;

    public void process(String statement) throws InvalidStatementException{
        // add 1.0 2.0
        String[] parts = statement.split(" ");

        if (parts.length != 3) {
            throw new InvalidStatementException("Incorrect number fields", statement);
        }

        String commandString = parts[0];

        try {

            leftValue = Double.parseDouble(parts[1]); // 1.0
            rightValue = Double.parseDouble(parts[2]); // 2.0
        } catch (NumberFormatException e ) {
            throw new InvalidStatementException("Non-numeric data", statement, e);

        }


        setCommandFromString(commandString);
        if (command==null)
        {
            throw new InvalidStatementException("Non-numeric data", statement);

        }

        CalculateBase calculator = null;

        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            default:
                break;
        }
        calculator.calculate();
        result = calculator.getResult();
    }

    public void setCommandFromString( String commandString) {

        if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command= MathCommand.Add;
        else if (commandString.equalsIgnoreCase((MathCommand.Subtract.toString())))
            command = MathCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;

    }

    @Override
    public String toString() {
        char symbol=' ';

        switch(command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Subtract:
                symbol = MINUS_SYBOL;
                break;
        }

        StringBuilder sb = new StringBuilder((20));
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
}
