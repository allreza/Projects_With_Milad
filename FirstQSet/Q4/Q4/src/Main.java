import java.util.*;

class Main {
    private static float Output;
    private static Scanner _input;
    private static float getOutput() {
        return Output;
    }
    private static void setOutput(float _output) {
        Output = _output;
    }

    public static void main(String [] args) {

        _input = new Scanner(System.in);
        modeSelect(_input.nextInt());
        myPrinter(getOutput());
        _input.close();
    }

    private static void myPrinter(float output) {

        //this rounding technique is found on United Top Tech on YouTube :)
        float _temp;
        _temp = Math.round(Math.abs(output * 100.0f)) / 100.0f;

         _temp = (output / Math.abs(output)) * _temp;

        if (_temp%1 == 0) {
            System.out.print((int)_temp);
        }
        else
            System.out.print(_temp);
    }

    private static void modeSelect(int _inputMode) {
        switch (_inputMode) {
            case 1 -> mySum();
            case 2 -> mySub();
            case 3 -> myMultiply();
            case 4 -> myDivision();
            case 5 -> myPow();
            case 6 -> mySqrt();
            case 7 -> mySin();
            case 8 -> myCos();
            case 9 -> myFactorial();
            case 10 -> myAverage();
            default -> {}
        }
    }

    private static void myDivision() {
        float x,y;
        float _output;

        x = _input.nextFloat();
        y = _input.nextFloat();

        _output = x/y;

        setOutput(_output);
    }

    private static void mySub() {
        float x,y;
        float _output;

        x = _input.nextFloat();
        y = _input.nextFloat();

        _output = x - y;

        setOutput(_output);

    }

    private static void myMultiply() {
        float x,y;
        float _output;

        x = _input.nextFloat();
        y = _input.nextFloat();

        _output = x * y;

        setOutput(_output);
    }

    private static void myPow() {
        float x,y;
        float _output;

        x = _input.nextFloat();
        y = _input.nextFloat();

        _output = (float) Math.pow(x,y);

        setOutput(_output);

    }

    private static void mySqrt() {
        float x;
        float _output;

        x = _input.nextFloat();

        _output = (float) Math.sqrt(x);

        setOutput(_output);
    }

    private static void mySin() {
        float x;
        float _output;

        x = _input.nextFloat();

        _output = (float) Math.sin(x);

        setOutput(_output);
    }

    private static void myCos() {
        float x;
        float _output;

        x = _input.nextFloat();

        _output = (float) Math.cos(x);

        setOutput(_output);

    }

    private static void myFactorial() {
        float x;
        float _output;

        x = _input.nextFloat();

        _output = FactorialCalc(x);
        setOutput(_output);
    }
    private static float FactorialCalc(float x) {
        float rtData = 1;
        if(x > 1)
        {
            rtData = x;
            rtData = FactorialCalc(--x) * rtData;
        }
            return rtData;
    }
    private static void myAverage() {
        float tempInput,_avg = 0;
        float _count = 0;
        float _output;

        do {
            tempInput = _input.nextFloat();
            if(tempInput != -1) {
                _avg += tempInput;
                _count++;
            }
        }
        while (tempInput != -1);

        _output = _avg / _count;
        setOutput(_output);
    }
    private static void mySum() {
        float x,y;
        float _output;

        x = _input.nextFloat();
        y = _input.nextFloat();

        _output = x + y;

        setOutput(_output);

    }
}
