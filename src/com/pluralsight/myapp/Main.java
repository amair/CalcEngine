package com.pluralsight.myapp;

import com.pluralsight.calcengine.*;

public class Main {

    public static void main(String[] args) {
//        useSwitchStatements();
//        useClassHeirachy();

//        useHelper();
        String[] statements = {
                "add 1.0 2.0",
                "power 5.0 2.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"

        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf(),
                new Divider(),
                new Multiplier(),
                new Subtractor()
        });

        for (String statement: statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

        }

    private static void useHelper() {
        String[] statements = {
                "add 1.0", //error only 1 param
                "add xx 25.0", // error string instead of double
                "addX 0.0 0.0", // error wrong command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();

        for (String statement: statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());

                if (e.getCause() !=null) {
                    System.out.println("Original error: "+ e.getCause().getMessage());
                }
            }

        }
    }

    private static void useClassHeirachy() {
        CalculateBase[] newEquations = {
                new Adder(25.0d,92.0d),
                new Divider(100.0d,50.0d),
                new Subtractor(225.0d,17.0d),
                new Multiplier(11.0d,3.0d)
        };

        for (CalculateBase newEquation: newEquations) {
            newEquation.calculate();
            System.out.print("result = ");
            System.out.println(newEquation.getResult());
        }
    }

    private static void useSwitchStatements() {
        MathEquation[] equations = new MathEquation[4];

        equations[0] = new MathEquation( 'd', 100.0d,50.0d );
        equations[1] = new MathEquation('a', 25.0d,92.0d );
        equations[2] = new MathEquation('s', 225.0d,17.0d );
        equations[3] = new MathEquation('m', 11.0d,3.0d );

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

    }


}
