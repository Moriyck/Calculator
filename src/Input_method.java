public enum Input_method {
    PATERN_NUM("^[1-9][0]*$"),
    PATERN_ARAB("^[IiVvXx1-9][0]*[\\+\\/\\*\\-]*[IiVvXx1-9][0]*$"),
    PATERN_NO_FORMAT("^\\w\\W\\w\\W\\w*$"),
    PATERN_ROM("^[IiVvXx]*[\\+\\/\\*\\-]*[IiVvXx]*$");

    String displayInput;

    Input_method(String displayInput) {
        this.displayInput = displayInput;

    }

    String getInput() {
        return displayInput;
    }
}
