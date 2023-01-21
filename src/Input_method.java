public enum Input_method {
    THE_STRING_MATCHES_THE_CONDITION("^[IiVvXx1-9]*[0]*[\\+\\/\\*\\-]*[IiVvXx1-9]*[0]*$"),
    PATERN_ARAB("^[IiVvXx1-9][0][\\+\\/\\*\\-]{0,1}[IiVvXx1-9][0]*$"),
    PATERN_NO_FORMAT("^\\w\\W\\w\\W\\w*$"),
    PATERN_ROM("^[IiVvXx][\\+\\/\\*\\-]{0,1}[IiVvXx]*$");

    // PATERN_NUM("^([1-9]|10)$"),
    // THE_STRING_MATCHES_THE_CONDITION( "^(([1-9]|10) ?([\\+\\-\\/\\*])
    // ?([1-9]|10)|([iIvVxX]+) ?([\\+\\-\\/\\*]) ?([iIvVxX]+))$"),
    String displayInput;

    Input_method(String displayInput) {
        this.displayInput = displayInput;
    }

    String getInput() {
        return displayInput;
    }
}
