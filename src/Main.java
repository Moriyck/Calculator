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

        if (logicalLayer.arabBooleanNoFormat == true) {
            enteredString.inputErrors = Input_errors.FORMAT_NOT_SATISFY_TASK;
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
            logicalLayer.romNull = converter.romNull;
        }

        logicalLayer.calculationResult();

        converter.result = logicalLayer.result;
        converter.convertRom();

        OutputData outputData = new OutputData();
        outputData.executionResult(converter.resultString);
    }
}