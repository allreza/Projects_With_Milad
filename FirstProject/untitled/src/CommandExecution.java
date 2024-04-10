import java.util.Dictionary;
import java.util.Hashtable;

public class CommandExecution {
    private Table innerTable = new Table();
    private Dictionary<String, String> commandInputs = new Hashtable<>();
    private final String[] commandsList = new String[]{"create", "drop", "add", "get", "set", "del"};

    public CommandExecution(String command) {

        String[] _commandArray = command.split("[\\[\\(\\{]");

        //Setting command and tableName
        String[] _tempArray = _commandArray[0].split("\\s+");
        if (!setExecAction(_tempArray[0])) {
            System.out.println("Command Action was not correct!");
            return;
        }
        innerTable.setTableName(_tempArray[1]);

        //Setting parameters, arguments and variables in this class
        for (int i = 0; i < _commandArray.length; i++) {

            if (_commandArray[i].contains(")")) {
                _commandArray[i] = _commandArray[i].replace(")", "");
                commandInputs.put("Parameters", _commandArray[i]);
            } else if (_commandArray[i].contains("]")) {
                _commandArray[i] = _commandArray[i].replace("]", "");
                commandInputs.put("Arguments", _commandArray[i]);
            } else if (_commandArray[i].contains("}")) {
                _commandArray[i] = _commandArray[i].replace("}", "");
                commandInputs.put("Variables", _commandArray[i]);
            }
        }
    }

    private boolean setExecAction(String execAction) {

        for (String _com : commandsList) {
            if (_com.equals(execAction))
            {
                commandInputs.put("ExecAction", execAction);
                return true;
            }
        }
        return false;
    }

    public boolean Execute() {
        System.out.println("execution was successful");
        return true;
    }
}


//        String[] _tempArrayArgs;
//        _tempArrayArgs = _commandArray[i].split("\\s*,\\s*");
//        for (String s : _tempArrayArgs) {
//            if (!s.matches(".[a-z\\d]+\\s+[a-z\\d]+.")) {
//                System.out.println("The argument '" + s + "' is not in the correct format!");
//                return;
//            }
//            String[] argumentParts = s.split("\\s+");
//
//            if (argumentParts[0].isBlank() || argumentParts[1].isBlank()) {
//                System.out.println("The argument '" + s + "' does not contain the type or name!");
//                return;
//            }
// innerTable.setArgument(argumentParts[0], argumentParts[1]);
//
//                    ArrayList<ArrayList<String>> str = new ArrayList<>();
//
//                    ArrayList<String> newLine = new ArrayList<>();
//                    str.add(newLine);
//        }

//            _commandArray[i] = _commandArray[i].replace(")", "");
//            _commandArray[i] = _commandArray[i].replace("]", "");
//            _commandArray[i] = _commandArray[i].replace("}", "");