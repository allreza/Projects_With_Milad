import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);

        int n = _input.nextInt();

        int[][] _fuseArray =  new int[2][n];
        int[] _onFuseCount = new int[2];
        int _fuseDifferences = 0;

        for (int i = 0; i < 2; i++) {
            String _tempStr = _input.next();
            for (int j = 0; j < n; j++) {
               _fuseArray[i][j] =  (_tempStr.charAt(j) - 48);

               if (_fuseArray[i][j] == 1)
                   _onFuseCount[i]++;

               if( i == 1 && (_fuseArray[1][j] != _fuseArray[0][j]))
                   _fuseDifferences++;
            }
        }

        if ((_onFuseCount[1] - _onFuseCount[0]) %2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println(_fuseDifferences / 2);
    }
}
