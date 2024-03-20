import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);

        int n = _input.nextInt();
        int k = _input.nextInt();
        String _number = _input.next();

        if (k >= n)
            return;

        myBigNumberFinder(n, k, _number);

        _input.close();
    }

    private static void myBigNumberFinder(int digitCount, int k, String number) {

        int[] digits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[i] = number.charAt(i) - 48;
        }



        int _changeCount = 0;
        for (int i = 0; i < k; i++) {

            for (int l = 0; l < digitCount; l++) {
                if (digits[l] != -1) {

                    if(l+1 >= digitCount)
                        continue;

                    if (digits[l] < digits[l + 1]) {
                        digits[l] = digits[l + 1];
                        digits[l + 1] = -1;
                        _changeCount++;
                        break;
                    }
                }
            }



            int[] tempDigits = new int[digitCount];

            for (int j = 0; j < digitCount; j++) {
                tempDigits[j] = -1;
            }

            int tempPointer = 0;
            for (int j = 0; j < digitCount; j++) {
                if (digits[j] != -1) {
                    tempDigits[tempPointer] = digits[j];
                    tempPointer++;
                }
            }

            digits = tempDigits;
        }

        if (_changeCount == 0)
        {
            for (int j = digitCount-1; j >= digitCount - k; j--) {
                digits[j] = -1;
            }
        }


        for (int j = 0; j < digitCount; j++) {
            if (digits[j] != -1)
                System.out.print(digits[j]);
        }
    }
}