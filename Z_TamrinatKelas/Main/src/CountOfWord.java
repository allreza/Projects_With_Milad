import java.util.Scanner;

public class CountOfWord {

    public static void main(String[] args) {
//        String _str1 = "Hello" + "World" + 5;

        //Scanner _input = new Scanner(System.in);
        String _str1 = "Hello this is a test for a test word code as it is a Hello world code";//_input.nextLine();

        int[] countOfWord = new int[500];
        String[] word = new String[500];
        int _counter = 0;

        MyWord myWord = new MyWord("Hello",12);
        myWord.print();
//
//        MyWord myWord1 = myWord;
//        myWord1._word = "as You Know";
//        myWord1.print();
//        myWord.print();
//
//        myWord1 = new MyWord();
//        myWord1.print();



        //plus in regex means more than one of that type
        String[] splitter = _str1.split("\\s+");

        for (int i = 0; i < splitter.length; i++) {
        }
        for (String s : splitter) {
            for (int j = 0; j <= _counter && j < splitter.length; j++) {
                if (s.equals(word[j]))
                    break;
                word[j] = s;
                _counter++;
            }
        }

        for (String s : splitter) {
            for (int k = 0; k < splitter.length; k++) {
                if (s.equals(word[k]))
                    countOfWord[k]++;
            }
        }

        for (int i = 0; i < splitter.length; i++) {
            System.out.println("Count of " + word[i] + " is: " + countOfWord[i]);
        }

    }
}
