package MateAcademia;

public class Calculator {

    public static String calculate(String operand1, String operand2, String operation){
        Number numbers = new Number(operand1, operand2);
        int number1 = numbers.getOperand1();
        int number2 = numbers.getOperand2();


        switch(operation){
            case "+":
                return Integer.toString(number1 + number2);
            case "-":
                return Integer.toString(number1 - number2);
            case "*":
                return Integer.toString(number1 * number2);
            case "/": if(number2>0){
                return Integer.toString(number1 /number2);
            }
            else {
                throw new ArithmeticException("Zero division");
            }
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }
}
