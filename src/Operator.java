public enum Operator {
    P("+"),
    M("-"),
    D("/"),
    U("*");

    String displayOperator;

    Operator(String displayOperator) {
        this.displayOperator = displayOperator;
    }

    String getOperator() {
        return displayOperator;
    }
}
