import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LogicalLayer {
    String[] data;
    String dataFirstNumber;
    String dataSecondNumber;

    int chtckFormat;
    int romArab;

    Boolean arabBooleanNoFormat;

    Boolean numBoolean1;
    Boolean numBoolean2;
    Boolean romBoolean1;
    Boolean romBoolean2;

    boolean romNull;

    void checkFormat() {

        Input_method inputMethodArab = Input_method.PATERN_NO_FORMAT;
        String patternArab = inputMethodArab.getInput();
        Pattern rArab = Pattern.compile(patternArab);
        Matcher mArab = rArab.matcher(dataFirstNumber);
        arabBooleanNoFormat = mArab.matches();
       

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
