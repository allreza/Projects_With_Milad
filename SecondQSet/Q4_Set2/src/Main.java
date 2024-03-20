import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner _input = new Scanner(System.in);
        int a = _input.nextInt();
        int b = _input.nextInt();


        System.out.println(digitToText(a*b));

        _input.close();
    }

    private static String digitToText(int i) {
        int _dah = i % 100;
        int _sad = (i/100) % 10;
        int _dhz = i/1000;

        String str = "";

        if(i != 0) {

            str += DhzGenerator(_dhz);
            str += SadGenerator(_sad);
            str += DahGenerator(_dah);
        }
        else
            str = "zero";

        return str;
    }

    private static String YekGenerator(int yek) {

        String _tempStr;
        switch (yek) {
            case 1 -> _tempStr = "one";
            case 2 -> _tempStr = "two";
            case 3 -> _tempStr = "three";
            case 4 -> _tempStr = "four";
            case 5 -> _tempStr = "five";
            case 6 -> _tempStr = "six";
            case 7 -> _tempStr = "seven";
            case 8 -> _tempStr = "eight";
            case 9 -> _tempStr = "nine";
            default -> _tempStr = "";
        }
        return _tempStr;
    }
    private static String DahGenerator(int dah) {

        if (dah>10 && dah<20)
            return TeenGenerator((dah % 10));

        String _tempStr;
        switch (dah / 10) {
            case 1 -> _tempStr = "ten ";
            case 2 -> _tempStr = "twenty ";
            case 3 -> _tempStr = "thirty ";
            case 4 -> _tempStr = "forty ";
            case 5 -> _tempStr = "fifty ";
            case 6 -> _tempStr = "sixty ";
            case 7 -> _tempStr = "seventy ";
            case 8 -> _tempStr = "eighty ";
            case 9 -> _tempStr = "ninety ";
            default -> _tempStr = "";
        }
        return (_tempStr + YekGenerator((dah % 10)));
    }
    private static String TeenGenerator(int teen) {
        String _tempStr;
        switch (teen) {
            case 1 -> _tempStr = "eleven";
            case 2 -> _tempStr = "twelve";
            case 3 -> _tempStr = "thirteen";
            case 4 -> _tempStr = "fourteen";
            case 5 -> _tempStr = "fifteen";
            case 6 -> _tempStr = "sixteen";
            case 7 -> _tempStr = "seventeen";
            case 8 -> _tempStr = "eighteen";
            case 9 -> _tempStr = "nineteen";
            default -> _tempStr = "";
        }
        return _tempStr;
    }

    private static String SadGenerator(int sad) {
        return sad<=0?"":(YekGenerator(sad) + " hundred ");
    }
    private static String DhzGenerator(int dhz) {
        return dhz<=0? "":(DahGenerator(dhz) + " thousand ");
    }
}