//This class is not important. made to create arguments as class
//but as I changed the program, this class became useless

public class TableArgument {
    private String argumentName;
    public String getArgumentName() {
        return argumentName;
    }

    private String argumentType;
    public String getArgumentType() {
        return argumentType;
    }

    public boolean SetArgument(String argType, String argName) {
        argumentType = argType;
        argumentName = argName;
        return true;
    }
}