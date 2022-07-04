import Entities.*;
import Auxiliary.Texts;
import Entities.ComplexNumber.ComplexNumber;
import Entities.ComplexNumber.ComplexNumberReader;
import Entities.History.HistoryMaker;
import Entities.History.HistoryTeller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {


        while (true) {

            Calculator calculator = new Calculator();
            ComplexNumberReader complexNumberReader = new ComplexNumberReader();
            HistoryMaker historyMaker = new HistoryMaker();
            HistoryTeller historyTeller = new HistoryTeller();
            ComplexNumber mainNumber = new ComplexNumber(0, 0);


            while (true) {

                System.out.println("Actual value: " + mainNumber.getFullNumber(calculator));
                System.out.println("Type of writing numbers: " + (calculator.isVectorEnable() ? "vector" : "numeric") + "\n \n");
                Texts.crossroad();


                switch (reader.readLine()) {
                    case ("enter number"):
                        System.out.println("please, enter number");
                        String newNum = reader.readLine();
                        mainNumber = complexNumberReader.defineComplexNumber(newNum, calculator);

                        break;

                    case ("add"):
                        System.out.println("Enter a complex number");
                        String tempAdd = reader.readLine();

                        ComplexNumber addedNumber = complexNumberReader.defineComplexNumber(tempAdd, calculator);
                        ComplexNumber addResult = calculator.add(mainNumber, addedNumber);

                        historyMaker.addToHistory(mainNumber, "+", addedNumber, addResult);
                        mainNumber = addResult;
                        break;


                    case ("subtract"):
                        System.out.println("Enter a complex number");
                        String tempSub = reader.readLine();

                        ComplexNumber subtractedNumber = complexNumberReader.defineComplexNumber(tempSub, calculator);
                        ComplexNumber subtractResult = calculator.subtract(mainNumber, subtractedNumber);
                        historyMaker.addToHistory(mainNumber, "-", subtractedNumber, subtractResult);
                        mainNumber = subtractResult;
                        break;


                    case ("multiply"):
                        System.out.println("Enter a complex number");
                        String tempMul = reader.readLine();

                        ComplexNumber multipliedNumber = complexNumberReader.defineComplexNumber(tempMul, calculator);
                        ComplexNumber multiplyResult = calculator.multiply(mainNumber, multipliedNumber);
                        historyMaker.addToHistory(mainNumber, "*", multipliedNumber, multiplyResult);
                        mainNumber = multiplyResult;
                        break;


                    case ("decide"):
                        System.out.println("Enter a complex number");
                        String tempDec = reader.readLine();

                        ComplexNumber decidedNumber = complexNumberReader.defineComplexNumber(tempDec, calculator);
                        ComplexNumber decideResult = calculator.decide(mainNumber, decidedNumber);
                        historyMaker.addToHistory(mainNumber, "/", decidedNumber, decideResult);
                        mainNumber = decideResult;
                        break;


                    case ("show history"):
                        historyTeller.tellAllHistory(historyMaker, calculator);
                        break;


                    case ("show results history"):
                        historyTeller.tellResultsHistory(historyMaker, calculator);
                        break;


                    case ("show operands history"):
                        historyTeller.tellOperandsHistory(historyMaker);
                        break;

                    case ("change the number entry type"):
                        calculator.clickSwitch();
                        break;

                    case ("clear"):
                        Texts.warningClearingHist();

                        switch (reader.readLine()) {
                            case ("yes"):
                                mainNumber = new ComplexNumber(0, 0);
                                historyMaker.clearHistory();
                                System.out.println("Calculation history cleared");
                                break;

                            case ("no"):
                                break;
                        }
                        break;


                    case ("exit"):
                        reader.close();
                        System.exit(0);
                }
            }
        }
    }

}
