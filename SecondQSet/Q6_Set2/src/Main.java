import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);

        int word_count = _input.nextInt();

        myWordFunction(word_count,_input);
        _input.close();
    }

    private static void myWordFunction(int _wordCount, Scanner _input) {

        //Maximum none is in group with others:
        String[] wordGroups = new String[_wordCount];
        for (int i = 0; i < _wordCount; i++)
            wordGroups[i] = "";

        String _tempWord;
        int groupCounter = 0;

        for (int i = 0; i < _wordCount; i++) {
            _tempWord = _input.next();

            //check if it is in any group
            int groupNumber = isInAnyGroup(wordGroups, _tempWord, (groupCounter + 1));

            //if not in any group add new group
            if (groupNumber == -1) {
                wordGroups[groupCounter] += _tempWord + " ";
                groupCounter++;
            } else
                wordGroups[groupNumber] += _tempWord + " ";
        }


        //Making new wordGroup as the groupsCount is known by the moment
        String[] newWordGroup = new String[groupCounter];
        for (int i = 0; i < groupCounter; i++)
            newWordGroup[i] = wordGroups[i];

        mySortFunction(newWordGroup,groupCounter);
    }

    private static void mySortFunction(String[] wordGroups, int groupCounter) {

        for (int i = 0; i < groupCounter; i++) {
            String[] _groupWords = wordGroups[i].split(" +");
             wordGroups[i] = sortGroupWords(_groupWords);
        }

        sortGroups(wordGroups, groupCounter);
        myPrinter(wordGroups, groupCounter);
    }

    private static void sortGroups(String[] wordGroups, int groupCounter) {

        for (int i = 0; i < groupCounter; i++) {
            for (int j = i; j < groupCounter; j++) {

                if (wordGroups[i].charAt(0) < wordGroups[j].charAt(0)) {
                    String _tempGroup = wordGroups[i];
                    wordGroups[i] = wordGroups[j];
                    wordGroups[j] = _tempGroup;
                }
            }
        }
    }

    private static String sortGroupWords(String[] groupWords) {

        for (int i = 0; i < groupWords.length; i++) {
            for (int j = i; j < groupWords.length; j++) {

                if (groupWords[i].compareTo(groupWords[j]) > 0) {
                    String _tempGroup = groupWords[i];
                    groupWords[i] = groupWords[j];
                    groupWords[j] = _tempGroup;
                }
            }
        }

        String _returnStr = "";
        for (int i = 0; i < groupWords.length; i++) {
            _returnStr += groupWords[i] + " ";
        }
        return _returnStr;
    }

    private static void myPrinter(String[] wordGroups, int groupCounter) {
        for (int i = 0; i < groupCounter; i++) {
            System.out.println(wordGroups[i]);
        }
    }

    private static int isInAnyGroup(String[] _wordGroups, String _newWord, int _groupCount ) {

        for (int i = 0; i < _groupCount; i++) {
            if (isGroupWith(_wordGroups[i],_newWord))
                return i;
        }
        return -1;
    }

    private static boolean isGroupWith(String wordGroup, String newWord) {
        if (wordGroup.equals(""))
            return false;

        String _tempWord = wordGroup.substring(0,wordGroup.indexOf(" "));
        int equalityCount = 0;

        for (int i = 0; i < newWord.length(); i++) {
            for (int j = 0; j < _tempWord.length(); j++) {
                if (newWord.charAt(i) == _tempWord.charAt(j))
                    equalityCount++;
            }
        }

        return equalityCount == _tempWord.length();
    }
}
