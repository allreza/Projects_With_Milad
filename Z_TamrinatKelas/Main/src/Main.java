import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Object[]> rows = new ArrayList<>();
        Object[] row1 = {"John", 15, 85.5};
        Object[] row2 = {"Jane", 17, 90.0};
        Object[] row3 = {"Bob", 16, 75.0};
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        Map<String, Integer> columns = new LinkedHashMap<>();
        columns.put("name", 0);
        columns.put("age", 1);
        columns.put("score", 2);

        String command = "age > 16 + name";
        System.out.println(getFilteredRows(command, columns, rows));
    }

    public static List<Object[]> getFilteredRows(String command, Map<String, Integer> columns, List<Object[]> rows) {
        Pattern pattern = Pattern.compile("(\\w+)\\s*[><=!]\\s*(-?\\d+|\\(\\w+\\))");
        Matcher matcher = pattern.matcher(command);
        Map<String, Object> filter = new LinkedHashMap<>();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            if (value.matches("\\(-?\\d+\\)")) {
                value = value.replaceAll("[\\(\\)]", "");
                value = String.valueOf(-Integer.parseInt(value));
            } else {
                value = value.replaceAll("\\w+", "$1");
            }
            filter.put(key, value);
        }

        String leftKey = null;
        for (String key : filter.keySet()) {
            if (filter.get(key) instanceof String) {
                leftKey = key;
                break;
            }
        }

        int leftIndex = columns.get(leftKey);
        List<Object[]> result = new ArrayList<>();
        for (Object[] row : rows) {
            if (evalFilter(filter, row[leftIndex])) {
                result.add(row);
            }
        }

        printTable(columns, result);
        return result;
    }

    public static boolean evalFilter(Map<String, Object> filter, Object value) {
        for (String key : filter.keySet()) {
            Object filterValue = filter.get(key);
            if (filterValue instanceof String) {
                if (value.equals(key)) {
                    return true;
                }
            } else {
                double numValue = Double.parseDouble(value.toString());
                if (key.equals(">")) {
                    return numValue > (double) filterValue;
                } else if (key.equals("<")) {
                    return numValue < (double) filterValue;
                } else if (key.equals(">=")) {
                    return numValue >= (double) filterValue;
                } else if (key.equals("<=")) {
                    return numValue <= (double) filterValue;
                } else if (key.equals("==")) {
                    return numValue == (double) filterValue;
                } else if (key.equals("!=")) {
                    return numValue != (double) filterValue;
                }
            }
        }
        return false;
    }

    public static void printTable(Map<String, Integer> columns, List<Object[]> rows) {
        System.out.printf("%-10s", "name");
        for (String column : columns.keySet()) {
            System.out.printf("%10s", column);
        }
    }
}