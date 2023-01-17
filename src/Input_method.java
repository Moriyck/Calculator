public enum Input_method {
    PATERN_NUM("^[1-9][0]*$"),
    PATERN_ARAB("^[1-9][0]*[\\+\\/\\*\\-]*[1-9][0]*$"),
    PATERN_ROM("^[IiVvXx]*[\\+\\/\\*\\-]*[IiVvXx]*$");

    String displayInput;

    Input_method(String displayInput) {
        this.displayInput = displayInput;

    }

    String getInput() {
        return displayInput;
    }

}
