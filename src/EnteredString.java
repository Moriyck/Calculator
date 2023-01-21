import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EnteredString {
    String inputString;
    int operatorIndex;
    Input_errors inputErrors;
    String inputErrorsString;
    String[] operatorsStrings = { "+", "-", "/", "*" };
    String[] regexActions = { "\\+", "-", "/", "\\*" };
    String[] data;
    String dataFirstNumber;
    String dataSecondNumber;
    Boolean arabBooleanNoFormat;

    void checkFormat() {
        try (Scanner keyboardScanner = new Scanner(System.in)) {
            inputString = keyboardScanner.nextLine();

            Input_method inputMethodMc = Input_method.THE_STRING_MATCHES_THE_CONDITION;
            String patternMc = inputMethodMc.getInput();
            Pattern rMc = Pattern.compile(patternMc);
            Matcher mMc = rMc.matcher(inputString);
            arabBooleanNoFormat = mMc.matches();
            if (!arabBooleanNoFormat) {
                inputErrors = Input_errors.FORMAT_NOT_SATISFY_TASK;
                inputErrorsString = inputErrors.getError();
            }
        } catch (Exception e) {
            System.out.println("Scanner err");
        }
    }

    void operatorSearch() {
        for (int i = 0; i < operatorsStrings.length; i++) {
            if (inputString.contains(operatorsStrings[i])) {
                operatorIndex = i;
                break;
            }
        }
    }

    void splitIntoTwo() {
        data = inputString.split(regexActions[operatorIndex]);
        dataFirstNumber = data[0];
        dataSecondNumber = data[1];
    }
}
