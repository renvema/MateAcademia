package MateAcademia;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number {
    private int operand1;
    private int operand2;
    private boolean isArabic;
    private Map<String, String> possibleNumbers = Stream.of(new String[][]{
            {"0", "N"},
            {"1", "I"},
            {"2", "II"},
            {"3", "III"},
            {"4", "IV"},
            {"5", "V"},
            {"6", "VI"},
            {"7", "VII"},
            {"8", "VIII"},
            {"9", "IX"},
            {"10", "X"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public Number(String operand1, String operand2) {
        if (isOperandsCorrect(operand1, operand2)) {
            this.operand1 = setOperand(operand1);
            this.operand2 = setOperand(operand2);
        } else {
            throw new ArithmeticException("Invalid operands");
        }
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    private int setOperand(String operand) {
        return !isArabic ? convertToArabic(operand) : Integer.parseInt(operand);
    }

    private boolean isOperandsCorrect(String operand1, String operand2) {
        if (possibleNumbers.containsKey(operand1) && possibleNumbers.containsKey(operand2)) {
            isArabic = true;
            return true;
        } else isArabic = false;
        return possibleNumbers.containsValue(operand1) && possibleNumbers.containsValue(operand2);

    }

    private int convertToArabic(String operand) {
        int result = -1;

        if (!possibleNumbers.containsValue(operand)) {
            throw new ArithmeticException("No such number");
        }
        for (Map.Entry<String, String> item : possibleNumbers.entrySet()) {
            if (item.getValue().equals(operand)) {
                result = Integer.parseInt(item.getKey());
                return result;
            }
        }
        return result;
    }
}

