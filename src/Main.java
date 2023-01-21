import javax.imageio.IIOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input: ");
        OutputData outputData = new OutputData();
        outputData.executionResult(calc(""));
    }

    public static String calc(String input) {
        EnteredString enteredString = new EnteredString();
        LogicalLayer logicalLayer = new LogicalLayer();
        Converter converter = new Converter();
        enteredString.checkFormat();
        if (!enteredString.arabBooleanNoFormat) {
            try {
                throw new IIOException(input);
            } catch (Exception e) {
                enteredString.inputErrors = Input_errors.FORMAT_NOT_SATISFY_TASK;
                input = enteredString.inputErrors.getError();
            }
        } else {
            try {
                enteredString.operatorSearch();
                enteredString.splitIntoTwo();
                try {
                    try {
                        logicalLayer.firstNumber = Integer.parseInt(enteredString.data[0]);
                        logicalLayer.secondNumber = Integer.parseInt(enteredString.data[1]);
                        logicalLayer.operator = enteredString.operatorsStrings[enteredString.operatorIndex];
                    } catch (Exception e) {
                        converter.a1 = enteredString.data[0];
                        converter.a2 = enteredString.data[1];
                        converter.convert();
                        logicalLayer.firstNumber = Integer.parseInt(converter.arabNum1);
                        logicalLayer.secondNumber = Integer.parseInt(converter.arabNum2);
                        logicalLayer.operator = enteredString.operatorsStrings[enteredString.operatorIndex];
                        converter.rom = true;
                    }
                    try {
                        logicalLayer.calculationResult();
                        try {
                            converter.result = logicalLayer.result;
                            converter.convertOutputRom();
                            input = converter.resultString;
                        } catch (Exception e) {
                            System.out.println("convertOutputRom ERROR");
                        }
                    } catch (Exception e) {
                        enteredString.inputErrors = Input_errors.INPUT_NUMBERS_FROM_1_TO_10_INCLUSIVE;
                        input = enteredString.inputErrors.getError();
                    }
                } catch (Exception e) {
                    enteredString.inputErrors = Input_errors.DIFFERENT_NUMBER_SYSTEMS;
                    input = enteredString.inputErrors.getError();
                }
            } catch (Exception e) {
                enteredString.inputErrors = Input_errors.STRING_NOT_MATH_OPERATION;
                input = enteredString.inputErrors.getError();
            }
        }
        return input;
    }
}