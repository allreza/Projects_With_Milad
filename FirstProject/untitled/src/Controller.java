import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private static String command;
    public static String getCommand() {
        return command;
    }
    public static boolean setCommand(String _command) {

         _command = _command.toLowerCase();

        Pattern pattern = Pattern.compile("[a-z]+\\s+[a-z\\d_]+\\s*(\\([a-z\\s\\d_,]+\\))?" +
                "\\s*(\\[((\\s*[a-z\\d_]+\\s+(str|int|dbl))\\s*(,(\\s*[a-z\\d_]+\\s+(str|int|dbl))\\s*)*)\\])?\\s*(\\{[a-z\\s\\d_,]+\\})?");
        Matcher matcher = pattern.matcher(_command);

        if (!matcher.matches()) {

            if (_command.isBlank()) {
                System.out.println("You haven't entered any command yet!\n");
                return false;
            }

            System.out.println("Command format is not correct!\n");
            return false;
        }

        command = _command;
        return true;
    }
    public static ArrayList<Table> tables;

    public Controller() {
        command = "";
        tables = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner _input = new Scanner(System.in);

        String _inputLine = _input.nextLine();

        while (!_inputLine.equalsIgnoreCase("quit")) {
            if (setCommand(_inputLine))
                new CommandExecution(getCommand()).Execute();
            _inputLine = _input.nextLine();
        }

        System.out.println("Thank you for using this database ;)");
    }
}