import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * @param args
     */

    public static void main(String[] args) {

        char firstCharacter;
        char secondCharacter;
        char thirdCharacter;
        char fourthCharacter;
        char fifthCharacter;
        int firstNumber;
        char operator;
        int operatorIndex;

        int secondNumber;
        int result;
        Boolean operatorSelection;
        Input_method inputMethod;
        int theNumberTen;

        Input_errors inputErrors;
        String inputErrorsString;

        String[] operatorsStrings = { "+", "-", "/", "*" };
        operatorIndex = -1;

        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("Input: ");
        String inputString = keyboardScanner.nextLine();

        int[] inputStringArry = new int[inputString.length()];

        for (int i = 0; i < inputStringArry.length; i++) {
            inputStringArry[i] = inputString.toCharArray()[i];
        }

        for (int i = 0; i < operatorsStrings.length; i++) {
            if (inputString.contains(operatorsStrings[i])) {
                operatorIndex = i;
                break;
            }
        }

        if (operatorIndex == -1) {
            inputErrors = Input_errors.STRING_NOT_MATH_OPERATION;
            inputErrorsString = inputErrors.getError();
            return;
        }

        System.out.println(operatorIndex);

        firstCharacter = inputString.charAt(0);

        firstNumber = Character.digit(inputString.charAt(0), 10);
        operator = inputString.charAt(1);
        secondNumber = Character.digit(inputString.charAt(2), 10);

        Input_method inputMethodArab = Input_method.PATERN_ARAB;
        Input_method inputMethodRom = Input_method.PATERN_ROM;
        String patternArab = inputMethodArab.getInput();
        String patternRom = inputMethodRom.getInput();
        Pattern r;
        Matcher m;

        if (Character.isDigit(firstCharacter) == false) {
            r = Pattern.compile(patternRom);
            m = r.matcher(inputString);
            operatorSelection = m.matches();
            return;
        } else {
            r = Pattern.compile(patternArab);
            m = r.matcher(inputString);
            operatorSelection = m.matches();

        }

        System.out.println("ARAB " + operatorsStrings[0]);

    }

}