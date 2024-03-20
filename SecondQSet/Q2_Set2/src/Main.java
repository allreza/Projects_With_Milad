import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner _input = new Scanner(System.in);

        String mainString = _input.nextLine();

        int _count = _input.nextInt();
        String[] strArray = new String[_count];

        for (int i = 0; i < _count; i++) {
            strArray[i] = _input.next();
        }

        String _tempString = "";
        for (String s : strArray) {
            _tempString += s;
            if (_tempString.equals(mainString))
            {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}