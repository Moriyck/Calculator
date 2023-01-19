public enum Input_errors {
    ROMAN_NEGATIVE_NUMBER("ИСКЛЮЧЕНИЕ: т.к. в римской системе нет отрицательных чисел "),
    DIFFERENT_NUMBER_SYSTEMS("ИСКЛЮЧЕНИЕ: т.к. используются одновременно разные системы счисления"),
    STRING_NOT_MATH_OPERATION("ИСКЛЮЧЕНИЕ: т.к. строка не является математической операцией"),
    FORMAT_NOT_SATISFY_TASK("ИСКЛЮЧЕНИЕ: т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

    String displayError;

    Input_errors(String displayError) {
        this.displayError = displayError;
    }

    String getError() {
        return displayError;
    }
}
