import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);
        String _str = _input.next();

        System.out.println(textDecoder(_str));

        _input.close();
    }
    private static String textDecoder(String _str) {
        String _tempString = "",_tempString2 = "",_tempString3 = "";
        char _tempChar;
        int _indexOfX = _str.lastIndexOf("x");

        if (_indexOfX != -1) {

            _tempString3 = _str.substring(_indexOfX+1);
            _str = _str.substring(0, (_indexOfX));

            for (int i = 0; i < _str.length(); i++) {
                //This reversing format is borrowed from geeks-for-geeks
                _tempChar = _str.charAt(i); //extracts each character
                _tempString = _tempChar + _tempString;
            }
            _str = _tempString;

                _tempString2 = textDecoder(_str);

            _str = _tempString2 + "x" + _tempString3;
        }

        return _str;
    }
}