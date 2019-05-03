package MateAcademia;

import java.util.Scanner;

public class CalculatorExecutor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter first operand:");
        String operand1 =  scan.next();

        System.out.println("Please enter second operand:");
        String operand2 = scan.next();

        System.out.println("Please enter operation: ");
        String operation = scan.next();

        String result = Calculator.calculate(operand1, operand2,operation);

        if ((operand1.contains("I")||operand1.contains("V")||operand1.contains("X")) && (operand2.contains("I")||operand2.contains("V")||operand2.contains("X"))) {
       
        System.out.println("Result of your operation is: "+Roman.format(Integer.parseInt(result)));}
else {System.out.println("Result of your operation is: "+result);}
    }
}
