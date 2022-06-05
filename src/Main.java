import Entities.Calculator;
import Entities.ComplexNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Entities.Calculator.add;
import static Entities.Calculator.subtract;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            Calculator calculator = new Calculator();
            ComplexNumber mainNumber = null;

            while(true) {

                if (mainNumber == null) {
                    System.out.println("Enter complex number");
                    mainNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                }

                System.out.println("Actual value: " + mainNumber.getFullNumber());

                System.out.println("Select an action:");
                System.out.println("\t enter new number \n" +
                        "\t add \n" +
                        "\t subtract \n" +
                        "\t multiply \n" +
                        "\t decide \n" +
                        "\t show history \n" +
                        "\t show results history \n" +
                        "\t clear \n" +
                        "\t exit \n");


                switch (reader.readLine()) {
                    case ("enter new number"):
                        System.out.println("Reset the available number?");

                            switch (reader.readLine()) {
                                case ("yes"):
                                    System.out.println("enter new number");
                                    mainNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                                    break;

                                case ("no"):
                                    break;
                            }
                        break;


                    case ("add"):

                        System.out.println("Enter a complex number");
                        ComplexNumber addedNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                        ComplexNumber addResult = add(mainNumber, addedNumber);
                        calculator.history.add(String.format("%s + %s = %s", mainNumber.getFullNumber(), addedNumber.getFullNumber(), addResult.getFullNumber()));
                        calculator.resultsHistory.add(addResult.getFullNumber());
                        mainNumber = addResult;
                        break;



                    case ("subtract"):
                        System.out.println("Enter a complex number");
                        ComplexNumber subtractedNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                        ComplexNumber subtractResult = subtract(mainNumber, subtractedNumber);
                        calculator.history.add(String.format("%s - %s = %s", mainNumber.getFullNumber(), subtractedNumber.getFullNumber(), subtractResult.getFullNumber()));
                        calculator.resultsHistory.add(subtractResult.getFullNumber());
                        mainNumber = subtractResult;
                        break;



                    case ("multiply"):
                        System.out.println("Enter a complex number");
                        ComplexNumber multipliedNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                        ComplexNumber multiplyResult = subtract(mainNumber, multipliedNumber);
                        calculator.history.add(String.format("%s * %s = %s", mainNumber.getFullNumber(), multipliedNumber.getFullNumber(), multiplyResult.getFullNumber()));
                        calculator.resultsHistory.add(multiplyResult.getFullNumber());
                        mainNumber = multiplyResult;
                        break;



                    case ("decide"):
                        System.out.println("Enter a complex number");
                        ComplexNumber decidedNumber = ComplexNumber.defineComplexNumber(reader.readLine());
                        ComplexNumber decideResult = subtract(mainNumber, decidedNumber);
                        calculator.history.add(String.format("%s / %s = %s", mainNumber.getFullNumber(), decidedNumber.getFullNumber(), decideResult.getFullNumber()));
                        calculator.resultsHistory.add(decideResult.getFullNumber());
                        mainNumber = decideResult;
                        break;



                    case ("show history"):
                        for (String calcHistory : calculator.history) {
                            System.out.println(calcHistory);
                        }
                        System.out.println("");
                        break;



                    case ("show results history"):
                        for (String resultsHistory : calculator.resultsHistory) {
                            System.out.println(resultsHistory);
                        }
                        System.out.println("");
                        break;


                    case ("clear"):
                        System.out.println("You are sure? \n" +
                                "The calculation history will be cleared \n" +
                                "and the number will be deleted");

                        switch (reader.readLine()) {
                            case ("yes"):
                                mainNumber = null;
                                calculator.resultsHistory.clear();
                                calculator.history.clear();
                                System.out.println("Calculation history cleared");
                                break;

                            case ("no"):
                                break;

                        }
                        break;



                    case ("exit"):
                        System.exit(0);

                    }



            }
        }
    }
}
