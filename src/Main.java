import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input: ");
        EnteredString enteredString = new EnteredString();

        enteredString.operatorIndex = -1;
        for (int i = 0; i < enteredString.operatorsStrings.length; i++) {
            if (enteredString.inputString.contains(enteredString.operatorsStrings[i])) {
                enteredString.operatorIndex = i;
                break;
            }
        }
        if (enteredString.operatorIndex == -1) {
            enteredString.inputErrors = Input_errors.STRING_NOT_MATH_OPERATION;
            enteredString.initialLine();
            return;
        }

        LogicalLayer logicalLayer = new LogicalLayer();
        logicalLayer.data = enteredString.inputString.split(enteredString.regexActions[enteredString.operatorIndex]);

        logicalLayer.dataFirstNumber = logicalLayer.data[0];
        logicalLayer.dataSecondNumber = logicalLayer.data[1];

        logicalLayer.checkFormat();

        if (logicalLayer.chtckFormat == 5) {
            enteredString.inputErrors = Input_errors.DIFFERENT_NUMBER_SYSTEMS;
            enteredString.initialLine();
            return;
        }

        if (logicalLayer.romArab == 1) {
            logicalLayer.firstNumber = Integer.parseInt(logicalLayer.data[0]);
            logicalLayer.secondNumber = Integer.parseInt(logicalLayer.data[1]);
            logicalLayer.operator = enteredString.operatorsStrings[enteredString.operatorIndex];
        }

        Converter converter = new Converter();
        converter.a1 = logicalLayer.data[0];
        converter.a2 = logicalLayer.data[1];

        if (logicalLayer.romArab == 2) {
            converter.convert();
            logicalLayer.firstNumber = Integer.parseInt(converter.arabNum1);
            logicalLayer.secondNumber = Integer.parseInt(converter.arabNum2);
            logicalLayer.operator = enteredString.operatorsStrings[enteredString.operatorIndex];
            converter.rom = true;
        }

        logicalLayer.calculationResult();

        converter.result = logicalLayer.result;
        converter.convertRom();

        OutputData outputData = new OutputData();
        outputData.executionResult(converter.resultString);

    }
}

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

class LogicalLayer {
    String[] data;
    String dataFirstNumber;
    String dataSecondNumber;

    int chtckFormat;
    int romArab;

    Boolean numBoolean1;
    Boolean numBoolean2;
    // Boolean arabBoolean;
    Boolean romBoolean1;
    Boolean romBoolean2;

    void checkFormat() {

        // Input_method inputMethodArab = Input_method.PATERN_ARAB;
        // String patternArab = inputMethodArab.getInput();
        // Pattern rArab = Pattern.compile(patternArab);
        // Matcher mArab = rArab.matcher(dataFirstNumber);
        // arabBoolean = mArab.matches();

        Input_method inputMethodRom1 = Input_method.PATERN_ROM;
        String patternRom1 = inputMethodRom1.getInput();
        Pattern rRom1 = Pattern.compile(patternRom1);
        Matcher mRom1 = rRom1.matcher(dataFirstNumber);
        romBoolean1 = mRom1.matches();

        Input_method inputMethodRom2 = Input_method.PATERN_ROM;
        String patternRom2 = inputMethodRom2.getInput();
        Pattern rRom2 = Pattern.compile(patternRom2);
        Matcher mRom2 = rRom2.matcher(dataSecondNumber);
        romBoolean2 = mRom2.matches();

        if (romBoolean1 == true & romBoolean2 == true) {
            romArab = 2;
            // "ROM ЧИСЛО";
        } else {
            romArab = 1;
            // "ARAB ЧИСЛО";
        }

        Input_method inputMethodNum = Input_method.PATERN_NUM;
        String patternNum = inputMethodNum.getInput();
        Pattern rNum = Pattern.compile(patternNum);
        Matcher mNum = rNum.matcher(dataFirstNumber);
        numBoolean1 = mNum.matches();

        Input_method inputMethodNum2 = Input_method.PATERN_NUM;
        String patternNum2 = inputMethodNum2.getInput();
        Pattern rNum2 = Pattern.compile(patternNum2);
        Matcher mNum2 = rNum2.matcher(dataSecondNumber);
        numBoolean2 = mNum2.matches();

        if (numBoolean1 == numBoolean2) {
            chtckFormat = 4;
            // "ОДИНАКОВЫЕ";
        } else {
            chtckFormat = 5;
            // "РАЗНЫЕ";
        }
    }

    String operator;
    int firstNumber;
    int secondNumber;
    int result;

    void calculationResult() {
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
        }

    }
}

class Converter {
    String a1;
    String a2;
    String arabNum1;
    String arabNum2;
    Roman_numerals roman_numerals1;
    Roman_numerals roman_numerals2;

    int result;
    String resultString = "";
    String resultRomString = "";
    boolean rom;
    int arabValue[] = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String romValue[] = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    void convert() {
        roman_numerals1 = Roman_numerals.valueOf(a1);
        arabNum1 = roman_numerals1.getRomNum();
        roman_numerals2 = Roman_numerals.valueOf(a2);
        arabNum2 = roman_numerals2.getRomNum();
    }

    void convertRom() {
        int i = -1;
      
        if (rom == true) {
            for (int item : arabValue) {
                i++;
                while (item <= result) {
                    resultString += romValue[i];
                    result -= item;
                }
            }
            return;
        } else {
            resultString = String.valueOf(result);
        }

    }
}

class OutputData {

    void executionResult(String resultString) {
        System.out.println("Output: ");
        System.out.println(resultString);
    }
}