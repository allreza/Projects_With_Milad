import java.util.Scanner;

public class Main{

    static long InputNumber;
    static long digitCount;

    public static void main(String[] args)
    {
        Scanner _input = new Scanner(System.in);
        InputNumber  = _input.nextInt();
        _input.close();

        digitCount = Long.toString(InputNumber).length();

        for(long i = 0; i <= digitCount; i++)
        {
            if(!isPrime(numRotator(i)))
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static long numRotator(long _shift)
    {

        //Defined as long because I am going to multiply _num in 10 so in case it gets out of short bounds, that could handle it :)
        long tempNum = InputNumber;
        long tempDigit;
        for(long i = 0; i < _shift; i++)
        {
            tempDigit = (long)(tempNum / Math.pow(10,digitCount - 1));

            tempNum = (long) ((tempNum * 10L) % Math.pow(10,digitCount) + tempDigit);
        }

        return tempNum;
    }

    public static boolean isPrime(long _num)
    {
        for(long i = 2; i <=(_num/2); i++)
        {
            if(_num % i == 0)
                return false;
        }

        return true;
    }
}