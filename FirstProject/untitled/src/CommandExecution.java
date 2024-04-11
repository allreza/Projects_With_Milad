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
                System.out.println("Unable to create table '" + innerTable.getTableName() + "'!");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[1])) {
            if (!DropTable()) {
                System.out.println("Unable to drop table!");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[2])) {
            if (!AddRows()) {
                System.out.println("Unable to add rows!");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[3])) {
            if (!GetRows()) {
                System.out.println("Unable to get rows!");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[4])) {
            if (!SetRows()) {
                System.out.println("Unable to set rows!");
                return false;
            }
        } else if (commandInputs.get("ExecAction").equals(commandsList[5])) {
            if (!DelRows()) {
                System.out.println("Unable to delete rows!");
                return false;
            }
        } else {
            System.out.println("Command was not in the execution commands' list!");
            return false;
        }

        System.out.println("execution was successful!");
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
        for (Table table : Controller.tables) {
            if (table.getTableName().equals(innerTable.getTableName())) {

                if(!table.AddRow(DistinctVariables()))
                {
                    System.out.println("Unable To add Row to '"+table.getTableName()+"!");
                    return false;
                }

                //TODO : you need to print the entered row as output
                return true;
            }
        }

        System.out.println("Unable to find table '" + innerTable.getTableName() + "'!");
        return false;
    }

    private Dictionary<String, String> DistinctVariables() {

            if (commandInputs.get("Variables") == null)
            {
                System.out.println("There are no variables to be set!");
                return null;
            }

            String[] _tempVariables;
            _tempVariables = commandInputs.get("Variables").trim().split("\\s*,\\s*");

            Dictionary<String,String> variables = new Hashtable<>();

            for (String s : _tempVariables) {
            String[] _variableParts = s.split("\\s*=\\s*");

            variables.put(_variableParts[0], _variableParts[1]);
        }

            return variables;
    }

    private boolean DropTable() {
        for (Table table : Controller.tables) {
            if (table.getTableName().equals(innerTable.getTableName())) {
                Controller.tables.remove(table);
                System.out.println("Table '"+innerTable.getTableName()+"' was successfully removed!");
                return true;
            }
        }

        System.out.println("Unable to drop table '"+innerTable.getTableName()+"'. no such table exists!");
        return false;
    }

    private boolean CreateTable() {

        for (Table table : Controller.tables) {
            if (table.getTableName().equals(innerTable.getTableName())) {
                System.out.println("table name '"+innerTable.getTableName()+"' Exists. Please change the name!");
                return false;
            }
        }

        if (SetArguments()) {
            Controller.tables.add(innerTable);
            System.out.println("Creating table '" + innerTable.getTableName() + "' was successful!");
            return true;
        }

        return false;
    }

    private boolean SetArguments() {

        String[] _tempArrayArgs;

        if (commandInputs.get("Arguments") == null)
        {
            System.out.println("There are no arguments to be set!");
            return false;
        }

        _tempArrayArgs = commandInputs.get("Arguments").trim().split("\\s*,\\s*");

        for (String s : _tempArrayArgs) {

            String[] argumentParts = s.split("\\s+");
            if (!innerTable.AddArgument(argumentParts[0], argumentParts[1]))
            {
                System.out.println("Unable to add argument '"+argumentParts[0]+"' to the table!");
                return false;
            }
        }

        return true;
    }
}