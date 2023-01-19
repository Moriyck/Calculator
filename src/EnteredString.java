import java.util.Scanner;

class EnteredString {
    char firstCharacter;

    int operatorIndex;

    Boolean operatorSelection;

    Input_errors inputErrors;
    String inputErrorsString;

    String[] operatorsStrings = { "+", "-", "/", "*" };
    String[] regexActions = { "\\+", "-", "/", "\\*" };

    Scanner keyboardScanner = new Scanner(System.in);
    String inputString = keyboardScanner.nextLine();

    void initialLine() {
        inputErrorsString = inputErrors.getError();
        System.out.println(inputErrorsString);
    }
}
