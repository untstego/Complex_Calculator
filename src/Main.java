import Entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            Calculator calculator = new Calculator();
            ComplexNumberReader complexNumberReader = new ComplexNumberReader();
            HistoryMaker historyMaker = new HistoryMaker();
            HistoryTeller historyTeller = new HistoryTeller();

            ComplexNumber mainNumber = null;

            while (true) {
                if (mainNumber == null) {
                    System.out.println("Enter complex number");
                    mainNumber = complexNumberReader.defineComplexNumber(reader.readLine());
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
                        "\t show operands history \n" +
                        "\t clear \n" +
                        "\t exit \n");


                switch (reader.readLine()) {
                    case ("enter new number"):
                        System.out.println("Reset the available number?");

                        switch (reader.readLine()) {
                            case ("yes"):
                                System.out.println("enter new number");
                                mainNumber = complexNumberReader.defineComplexNumber(reader.readLine());
                                break;

                            case ("no"):
                                break;
                        }
                        break;


                    case ("add"):
                        System.out.println("Enter a complex number");
                        ComplexNumber addedNumber = complexNumberReader.defineComplexNumber(reader.readLine());
                        ComplexNumber addResult = calculator.add(mainNumber, addedNumber);
                        historyMaker.addToHistory(mainNumber.getFullNumber(), " + ", addedNumber.getFullNumber(), addResult.getFullNumber());
                        mainNumber = addResult;
                        break;


                    case ("subtract"):
                        System.out.println("Enter a complex number");
                        ComplexNumber subtractedNumber = complexNumberReader.defineComplexNumber(reader.readLine());
                        ComplexNumber subtractResult = calculator.subtract(mainNumber, subtractedNumber);
                        historyMaker.addToHistory(mainNumber.getFullNumber(), " - ", subtractedNumber.getFullNumber(), subtractResult.getFullNumber());
                        mainNumber = subtractResult;
                        break;


                    case ("multiply"):
                        System.out.println("Enter a complex number");
                        ComplexNumber multipliedNumber = complexNumberReader.defineComplexNumber(reader.readLine());
                        ComplexNumber multiplyResult = calculator.multiply(mainNumber, multipliedNumber);
                        historyMaker.addToHistory(mainNumber.getFullNumber(), " * ", multipliedNumber.getFullNumber(), multiplyResult.getFullNumber());
                        mainNumber = multiplyResult;
                        break;


                    case ("decide"):
                        System.out.println("Enter a complex number");
                        ComplexNumber decidedNumber = complexNumberReader.defineComplexNumber(reader.readLine());
                        ComplexNumber decideResult = calculator.decide(mainNumber, decidedNumber);
                        historyMaker.addToHistory(mainNumber.getFullNumber(), " / ", decidedNumber.getFullNumber(), decideResult.getFullNumber());
                        mainNumber = decideResult;
                        break;


                    case ("show history"):
                        historyTeller.tellAllHistory(historyMaker);
                        break;


                    case ("show results history"):
                        historyTeller.tellResultsHistory(historyMaker);
                        break;


                    case ("show operands history"):
                        historyTeller.tellOperandsHistory(historyMaker);
                        break;


                    case ("clear"):
                        System.out.println("You are sure? \n" +
                                "The calculation history will be cleared \n" +
                                "and the number will be deleted");

                        switch (reader.readLine()) {
                            case ("yes"):
                                mainNumber = null;
                                historyMaker.clearHistory();
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
