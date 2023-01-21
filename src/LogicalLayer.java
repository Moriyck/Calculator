class LogicalLayer {
    String operator;
    int firstNumber;
    int secondNumber;
    int result;

    void calculationResult() {
        if (firstNumber < 1 || firstNumber > 10) {
            operator = "";
        }
        if (secondNumber < 1 || secondNumber > 10) {
            operator = "";
        }
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}
