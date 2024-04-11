import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

public class Table {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private ArrayList<Object[]> Rows = new ArrayList<>();
    private ArrayList<TableArgument> Arguments = new ArrayList<>();

    ///Allowed types are int, dbl, str
    public boolean AddArgument(String argName, String argType) {

        TableArgument _tempArgument = new TableArgument();
        if (!_tempArgument.SetArgument(argType, argName))
            return false;

        Arguments.add(_tempArgument);
        System.out.println("Argument '" + argName + "' was successfully added!");
        return true;
    }


    public boolean AddRow(Dictionary<String, String> _row) {
        Object[] _tempRow = new Object[Arguments.size()];

        //for (int i = 0; i < Arguments.size(); i++) {

            //
//            String _tempVariable = _row.get(Arguments.get(i).getArgumentName());
//            if (_tempVariable == null) {
//
//            }
//                Arguments.get(i).getArgumentType();
//        }
        System.out.println("The Dictionary is: " + _row);

        return true;
    }
}