public enum Input_errors {
    ROMAN_NEGATIVE_NUMBER("В римской системе нет отрицательных чисел."),
    DIFFERENT_NUMBER_SYSTEMS("Используются одновременно разные системы счисления."),
    STRING_NOT_MATH_OPERATION("Строка не является математической операцией."),
    FORMAT_NOT_SATISFY_TASK("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)."),
    INPUT_NUMBERS_FROM_1_TO_10_INCLUSIVE("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");

    String displayError;

    Input_errors(String displayError) {
        this.displayError = displayError;
    }

    String getError() {
        return displayError;
    }
}
