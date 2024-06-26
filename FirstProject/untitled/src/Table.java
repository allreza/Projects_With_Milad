import java.util.*;

public class Table {

    private String tableName;

    public Table() {
    }

    //Class copier Koli
    public Table(Table table) {
        this.tableName = table.getTableName();
        this.Rows.addAll(table.Rows);
        this.Arguments.putAll(table.Arguments);
    }
    //Class copier for Filter usage
    public Table(Table table , ArrayList<Object[]> newRows) {
        this.tableName = table.getTableName();
        this.Rows.addAll(newRows);
        this.Arguments.putAll(table.Arguments);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private ArrayList<Object[]> Rows = new ArrayList<>();
    private LinkedHashMap<String, String> Arguments = new LinkedHashMap<>();

    ///Allowed types are int, dbl, str
    public boolean AddArgument(String argName, String argType) {
        Arguments.put(argName, argType);

        System.out.println("Argument '" + argName + "' was successfully added!");
        return true;
    }

    public boolean AddRow(Dictionary<String, String> _row) {
        Object[] _tempRow = new Object[Arguments.size()];

        //Check if all Variables exist in Arguments
        Enumeration<String> rowKeys = _row.keys();
        for (int i = 0; i < _row.size(); i++) {
            String _tempKey = rowKeys.nextElement();

            String _tempVariable = Arguments.get(_tempKey);
            if (_tempVariable == null) {
                System.out.println("Variable '" + _tempKey + "' doesn't exist as a table variable!");
                return false;
            }
        }

        //Add variables into the new table row
        String[] tableKeys = Arguments.sequencedKeySet().toArray(new String[0]);
        for (int i = 0; i < Arguments.size(); i++) {
            String _tempKey = tableKeys[i];
            String _tempVariable = _row.get(_tempKey);

            if (_tempVariable == null) {
                switch (Arguments.get(_tempKey)) {
                    case "int" -> _tempRow[i] = 0;
                    case "dbl" -> _tempRow[i] = 0.0;
                    case "str" -> _tempRow[i] = "";
                }
            } else {

                switch (Arguments.get(_tempKey)) {
                    case "int":
                        try {
                            _tempRow[i] = Integer.parseInt(_tempVariable);
                        } catch (NumberFormatException e) {
                            System.out.println("the Value for argument'" + _tempKey + "' is '" + _tempVariable + "' which is not an integer!");
                            return false;
                        }
                        break;
                    case "dbl":
                        try {
                            _tempRow[i] = Double.parseDouble(_tempVariable);
                        } catch (NumberFormatException e) {
                            System.out.println("the Value for argument'" + _tempKey + "' is '" + _tempVariable + "' which is not a double!");
                            return false;
                        }
                        break;
                    case "str":
                        _tempRow[i] = _tempVariable.replace("'", "");
                        break;
                }
            }
        }

        Rows.add(_tempRow);
        PrintRow(_tempRow);
        return true;
    }

    private void PrintRow(Object[] printRow) {
        for (String key : Arguments.keySet()) {
            System.out.printf("%-20s", key);
        }
        System.out.println();

        for (Object obj : printRow) {
            if (obj.getClass().equals(String.class))
                System.out.printf("%-20s", "'" + obj + "'");
            else
                System.out.printf("%-20s", obj.toString());
        }

        System.out.println();
    }

    public void PrintRows(ArrayList<Object[]> printRow) {
        for (String key : Arguments.keySet()) {
            System.out.printf("%-20s", key);
        }
        System.out.println();
        for (Object[] objects : printRow) {
            for (Object obj : objects) {
                if (obj.getClass().equals(String.class))
                    System.out.printf("%-20s", "'" + obj + "'");
                else
                    System.out.printf("%-20s", obj.toString());
            }
            System.out.println();
        }
    }

    public void PrintWholeTable() {
        PrintRows(Rows);
    }

    //Returns rows as filter requested
    public ArrayList<Object[]> GetFilteredRows(String[] _filter) {
        ArrayList<Object[]> tempRows = new ArrayList<>();

            String[][] argsP1_2 = new String[2][];

            for (int i = 0; i < 2; i++) {
                argsP1_2[i] = _filter[i].trim().split("\\s*[\\+-]\\s*");

            }


            //double filter
            if (argsP1_2[0][0].matches("\\d+.\\d+") || "dbl".equals(Arguments.get(argsP1_2[0][0]))) {
                for (String[] strings : argsP1_2) {
                    for (String argument : strings) {
                        if (!(argument.matches("\\d+.\\d+") || "dbl".equals(Arguments.get(argument)))) {
                            System.out.println("Not all arguments are from double type!");
                            return new ArrayList<>();
                        }
                    }
                }

                for (Object[] row : Rows) {
                    double[] dblP12 = new double[2];

                    int counter = 0;
                    for (String argument : Arguments.sequencedKeySet()) {
                        for (int i = 0; i < 2; i++) {
                            for (String arg : argsP1_2[i]) {
                                if (argument.equals(arg))
                                    dblP12 [i] += (double) row[counter];
                            }
                        }
                        counter++;
                    }

                    for (int i = 0; i < 2; i++) {
                        for (String arg : argsP1_2[i]) {
                            if (arg.matches("\\d+.\\d*"))
                                dblP12[i] = Double.parseDouble(arg);
                        }
                    }

                    if (_filter[2].equals(">") && dblP12[0] > dblP12[1])
                        tempRows.add(row);
                    else if (_filter[2].equals("<") && dblP12[0] < dblP12[1])
                        tempRows.add(row);
                    else if (_filter[2].equals("=") && dblP12[0] == dblP12[1])
                        tempRows.add(row);
                }
            }

            //integer filter
            else if (argsP1_2[0][0].matches("\\d+") || "int".equals(Arguments.get(argsP1_2[0][0]))) {
                for (String[] strings : argsP1_2) {
                    for (String argument : strings) {
                        if (!(argument.matches("\\d+") || "int".equals(Arguments.get(argument)))) {
                            System.out.println("Not all arguments are from int type!");
                            return new ArrayList<>();
                        }
                    }
                }

                for (Object[] row : Rows) {
                    int[] intP12 = new int[2];

                    int counter = 0;
                    for (String argument : Arguments.sequencedKeySet()) {
                        for (int i = 0; i < 2; i++) {
                            for (String arg : argsP1_2[i]) {
                                if (argument.equals(arg))
                                    intP12[i] += (int) row[counter];
                            }
                        }
                        counter++;
                    }

                    for (int i = 0; i < 2; i++) {
                        for (String arg : argsP1_2[i]) {
                            if (arg.matches("\\d+"))
                                intP12[i] = Integer.parseInt(arg);
                        }
                    }

                    if (_filter[2].equals(">") && intP12[0] > intP12[1])
                        tempRows.add(row);
                    else if (_filter[2].equals("<") && intP12[0] < intP12[1])
                        tempRows.add(row);
                    else if (_filter[2].equals("=") && intP12[0] == intP12[1])
                        tempRows.add(row);
                }
            }

            //string filter
            else if (argsP1_2[0][0].matches("'.+'") || "str".equals(Arguments.get(argsP1_2[0][0]))) {
            for (String[] strings : argsP1_2) {
                for (String argument : strings) {
                    if (!(argument.matches("'.+'") || "str".equals(Arguments.get(argument)))) {
                        System.out.println("Not all arguments are from string type!");
                        return new ArrayList<>();
                    }
                }
            }

            //need to be optimized for string types because one argument should be accepted simultaneously
                // بین جمع و تفریق قائل بشه تو هر کدوم جدا
                // الان فقط همه رو جمع میزنه
//                String[] chars = {">", "<", "="};
//                for (String c : chars) {
//                    if (s.contains(c)) {
//                        paramParts[2] = c;
//                    }
//                {
//                get students (id - 402120 > age + weight)

            for (Object[] row : Rows) {
                String[] stringP12 = new String[2];

                int counter = 0;
                for (String argument : Arguments.sequencedKeySet()) {
                    for (int i = 0; i < 2; i++) {
                        for (String arg : argsP1_2[i]) {
                            if (argument.equals(arg))
                                stringP12 [i] = "'" + row[counter] + "'";
                        }
                    }
                    counter++;
                }

                for (int i = 0; i < 2; i++) {
                    for (String arg : argsP1_2[i]) {
                        if (arg.matches("'.+'"))
                            stringP12[i] = arg;
                    }
                }

                if (_filter[2].equals(">") && stringP12[0].compareTo(stringP12[1]) > 0)
                    tempRows.add(row);
                else if (_filter[2].equals("<") && stringP12[0].compareTo(stringP12[1]) < 0)
                    tempRows.add(row);
                else if (_filter[2].equals("=") && stringP12[0].equals(stringP12[1]))
                    tempRows.add(row);
            }
        }

        return tempRows;
    }

    public void DeleteAllRows() {

        int length = Rows.size();
        for (int i = 0; i < length; i++) {
            Rows.remove(0);
        }

        System.out.println(length + " rows were deleted from table '"+ this.getTableName() +"'");
    }

    public void DeleteRows(ArrayList<Object[]> returnedRows) {
        int deleteCount = 0;

        for (Object[] row : returnedRows) {
            Rows.remove(row);
            deleteCount++;
        }

        System.out.println(deleteCount + " rows were deleted from table '"+ this.getTableName() +"'");
    }
}