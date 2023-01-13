import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String inputString;
        int firstNumber;
        int secondNumber;
        char calculationSign;
        int result;
        // -------------------------Ошибки---------------------------------

        /*
         * "т.к. в римской системе нет отрицательных чисел ",
         * "т.к. используются одновременно разные системы счисления",
         * "т.к. строка не является математической операцией",
         * "т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)"
         */

        try (Scanner keyboardScanner = new Scanner(System.in)) {
            System.out.println("Введите знинчения для вычисления ");
            inputString = keyboardScanner.nextLine();

            firstNumber = Character.digit(inputString.charAt(0), 10);
            calculationSign = inputString.charAt(1);
            secondNumber = Character.digit(inputString.charAt(2), 10);

            switch (calculationSign) {
                case '+':
                    result = firstNumber + secondNumber;
                    System.out.println("Результат " + result);
                    break;

                case '-':
                    result = firstNumber - secondNumber;
                    System.out.println("Результат " + result);
                    break;

                case '*':
                    result = firstNumber * secondNumber;
                    System.out.println("Результат " + result);
                    break;

                case '/':
                    result = firstNumber - secondNumber;
                    System.out.println("Результат " + result);
                    break;
                default:
                    System.out.println(" т.к. в римской системе нет отрицательных чисел ");
                    break;
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА ");
        }
    }
}