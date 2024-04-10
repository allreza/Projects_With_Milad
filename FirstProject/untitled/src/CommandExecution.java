import java.util.Dictionary;
import java.util.Hashtable;

public class CommandExecution {
    private Table innerTable;
    private Dictionary<String, String> commandInputs;
    private static final String[] commandsList = new String[]{"create", "drop", "add", "get", "set", "del"};

    public CommandExecution(String command) {
        innerTable = new Table();
        commandInputs = new Hashtable<>();

        String[] _commandArray = command.split("[\\[\\(\\{]");

        //Setting command and tableName
        String[] _tempArray = _commandArray[0].split("\\s+");
        if (!SetExecAction(_tempArray[0])) {
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

    private boolean SetExecAction(String execAction) {

        for (String _com : commandsList) {
            if (_com.equals(execAction)) {
                commandInputs.put("ExecAction", execAction);
                return true;
            }
        }
        return false;
    }

    public boolean Execute() {

        if (commandInputs.get("ExecAction").equals(commandsList[0])) {
            if (!CreateTable()) {
                System.out.println("Unable to create table '" + innerTable.getTableName() + "'!\n");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[1])) {
            if (!DropTable()) {
                System.out.println("Unable to drop table!\n");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[2])) {
            if (!AddRows()) {
                System.out.println("Unable to add rows!\n");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[3])) {
            if (!GetRows()) {
                System.out.println("Unable to get rows!\n");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[4])) {
            if (!SetRows()) {
                System.out.println("Unable to set rows!\n");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[5])) {
            if (!DelRows()) {
                System.out.println("Unable to delete rows!\n");
                return false;
            }
        } else {
            System.out.println("Command was not in the execution commands' list!");
            return false;
        }

        System.out.println("execution was successful");
        return true;
    }

    private boolean DelRows() {
        return true;
    }

    private boolean SetRows() {
        return true;
    }

    private boolean GetRows() {
        return true;
    }

    private boolean AddRows() {
        return true;
    }

    private boolean DropTable() {
        return true;
    }

    private boolean CreateTable() {
        if (SetArguments()) {

            Controller.tables.add(innerTable);
            System.out.println("Creating table '" + innerTable.getTableName() + "' was successful!\n");
            return true;
        }

        return false;
    }

    private boolean SetArguments() {

        String[] _tempArrayArgs;
        _tempArrayArgs = commandInputs.get("Arguments").trim().split("\\s*,\\s*");
        for (String s : _tempArrayArgs) {

            String[] argumentParts = s.split("\\s+");
            if (!innerTable.AddArgument(argumentParts[0], argumentParts[1]))
            {
                System.out.println("Unable to add argument '"+argumentParts[0]+"' to the table!\n");
                return false;
            }
        }

            //ArrayList<ArrayList<String>> str = new ArrayList<>();
            //ArrayList<String> newLine = new ArrayList<>();
            //str.add(newLine);

        return true;
    }
}