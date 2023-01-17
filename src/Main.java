import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * @param args
     */

    public static void main(String[] args) {

        char firstCharacter;

        int firstNumber;
        int secondNumber;

        String operator;
        int operatorIndex;

        int result;
        Boolean operatorSelection;

        Input_errors inputErrors;
        String inputErrorsString;

        String[] operatorsStrings = { "+", "-", "/", "*" };
        String[] regexActions = { "\\+", "-", "/", "\\*" };

        operatorIndex = -1;

        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("Input: ");
        String inputString = keyboardScanner.nextLine();

        for (int i = 0; i < operatorsStrings.length; i++) {
            if (inputString.contains(operatorsStrings[i])) {
                operatorIndex = i;
                break;
            }
        }

        if (operatorIndex == -1) {
            inputErrors = Input_errors.STRING_NOT_MATH_OPERATION;
            inputErrorsString = inputErrors.getError();
            System.out.println(inputErrorsString);
            return;
        }

        String[] data = inputString.split(regexActions[operatorIndex]);
        operator = operatorsStrings[operatorIndex];

        String numberOneString = data[0];
        for (int i = 0; i < numberOneString.length(); i++) {
            String letter = Character.toString(numberOneString.charAt(i));
            // int pos = numberOneString.indexOf(i);

            Roman_numerals rNumerals = Roman_numerals.valueOf(letter); // II =2

            System.out.println(rNumerals.displayRomNum);
            System.out.println(letter);
            System.out.println(rNumerals);
        }

        // firstNumber = Integer.parseInt(data[0]);
        // secondNumber = Integer.parseInt(data[1]);

        firstNumber = 1;
        secondNumber = 1;

        Input_method inputMethodNum = Input_method.PATERN_NUM;
        String patternNum = inputMethodNum.getInput();
        Pattern rNum = Pattern.compile(patternNum);
        Matcher mNum = rNum.matcher(data[0]);
        Boolean numBoolean = mNum.matches();
        if (numBoolean == true) {
            System.out.println("ЧИСЛО");

        }

        Input_method inputMethodArab = Input_method.PATERN_ARAB;
        String patternArab = inputMethodArab.getInput();
        Pattern rArab;
        rArab = Pattern.compile(patternArab);
        Matcher mArab = rArab.matcher(inputString);
        Boolean arabBoolean = mArab.matches();
        if (arabBoolean == true) {

            System.out.println("ARAB ЧИСЛО");
        }

        Input_method inputMethodRom = Input_method.PATERN_ROM;
        String patternRom = inputMethodRom.getInput();
        Pattern rRom = Pattern.compile(patternRom);
        Matcher mRom = rRom.matcher(inputString);
        Boolean romBoolean = mRom.matches();
        if (romBoolean == arabBoolean) {

            System.out.println("ROM ЧИСЛО");
        }

        if (numBoolean == true & arabBoolean == true) {

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    System.out.println("Output:");
                    System.out.println(result);
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    System.out.println("Output:");
                    System.out.println(result);
                    break;

                case "*":
                    result = firstNumber * secondNumber;
                    System.out.println("Output:");
                    System.out.println(result);
                    break;

                case "/":
                    result = firstNumber / secondNumber;
                    System.out.println("Output:");
                    System.out.println(result);
                    break;
            }

            System.out.println("Один формат");
        } else {
            inputErrors = Input_errors.DIFFERENT_NUMBER_SYSTEMS;
            inputErrorsString = inputErrors.getError();
            System.out.println(inputErrorsString);
            return;
        }
    }

}