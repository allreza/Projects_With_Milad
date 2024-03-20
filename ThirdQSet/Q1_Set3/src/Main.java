import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String urlInput;
    private static String urlOutput;

    public static void main(String[] args) {

        Scanner _input = new Scanner(System.in);
        setUrlInput(_input.next());

        if (isCorrectUrl())
            System.out.println("True");
        else
            System.out.println("False");

        _input.close();

    }


    private static boolean isCorrectUrl() {

        Pattern pattern = Pattern.compile("@([a-zA-Z0-9]+)\\.([a-zA-Z]{2,5})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(getUrlInput());

        return false;
        //"new text for new condition as I know"
    }


    public static String getUrlInput() {
        return urlInput;
    }
    public static void setUrlInput(String urlInput) {
        Main.urlInput = urlInput;
    }
    public static String getUrlOutput() {
        return urlOutput;
    }
    public static void setUrlOutput(String urlOutput) {
        Main.urlOutput = urlOutput;
    }
}