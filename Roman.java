package MateAcademia;

public class Roman {public static String format(int value) {

    String romanNum = "";


    while (value > 0) {

        while (value >= 100) {
            romanNum = romanNum + "C";
            value -= 100;
        }
        while (value >= 90) {
            romanNum = romanNum + "XC";
            value -= 90;
        }
        while (value >= 50) {
            romanNum = romanNum + "L";
            value -= 50;
        }
        while (value >= 40) {
            romanNum = romanNum + "XL";
            value -= 40;
        }
        while (value >= 10) {
            romanNum = romanNum + "X";
            value -= 10;
        }
        while (value >= 9) {
            romanNum = romanNum + "IX";
            value -= 9;
        }
        while (value >= 5) {
            romanNum = romanNum + "V";
            value -= 5;
        }
        while (value >= 4) {
            romanNum = romanNum + "IV";
            value -= 4;
        }
        while (value >= 1) {
            romanNum = romanNum + "I";
            value -= 1;
        }

    }
    return romanNum;
}

    public static int parse(String number) {


        int lengthOfNumber = number.length();


        int[] value = new int[lengthOfNumber];



        for (int i = lengthOfNumber; i> 0;i-=1) {
            if (number.charAt(i-1)==('I'))
                value [i-1]= 1;
            else if (number.charAt(i -1)==('V'))
                value [i-1]= 5;
            else if (number.charAt(i -1)==('X'))
                value [i-1]= 10;
            else if (number.charAt(i -1)==('L'))
                value [i-1]= 50;
            else if (number.charAt(i -1)==('C'))
                value [i-1]= 100;

            else
                return -1;
        }


        for(int i = 0; i < lengthOfNumber -3; i+=1){
            if(value [i] == value[i+1] && value [i+1] == value[i+2] && value [i+2] == value[i+3]){
                return -1;
            }
        }



        int total = value [lengthOfNumber-1];
        for (int i = lengthOfNumber;i > 1;i-=1) {
            if (value[i -1] <= value[i - 2]){
                total+=value[i-2];
            }
            if (value[i -1 ] > value[i - 2]){
                total-=value[i-2];
            }


        }



        return total;
    }

    public static void main(String[] argv) {

        System.out.println("parse() tests:\n");



        int xcParse = parse("XC");
        if(xcParse == 90) {
            System.out.println("XC: Success");
        }else{
            System.out.println("XC: Fail " + xcParse);
        }

        int xlParse = parse("XL");
        if(xlParse == 40) {
            System.out.println("XL: Success");
        }else{
            System.out.println("XL: Fail " + xlParse);
        }

        int ixParse = parse("IX");
        if(ixParse == 9) {
            System.out.println("IX: Success");
        }else{
            System.out.println("IX: Fail " + ixParse);
        }

        int ivParse = parse("IV");
        if(ivParse == 4) {
            System.out.println("IV: Success");
        }else{
            System.out.println("IV: Fail " + ivParse);
        }



        int notRoman = parse("banana");

        if(notRoman == -1) {
            System.out.println("Not Roman Input: Success");
        }else{
            System.out.println("Not Roman Input: Fail " + notRoman);
        }


        int improperRoman = parse("IIII");

        if(improperRoman == -1) {
            System.out.println("Improper Roman Input: Success");
        }else{
            System.out.println("Improper Roman Input: Fail " + improperRoman);
        }


        System.out.println("\nformat() tests:\n");



    }

}
