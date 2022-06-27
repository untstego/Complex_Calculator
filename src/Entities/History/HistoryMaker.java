package Entities.History;

import Entities.ComplexNumber.ComplexNumber;

import java.util.ArrayList;

public class HistoryMaker {

    private ArrayList<HistoryLine> history = new ArrayList<>();


    public ArrayList<HistoryLine> getHistory() {
        return history;
    }


    public void addToHistory(ComplexNumber firstNumber, String operand, ComplexNumber secondNumber, ComplexNumber resultNumber) {
        this.history.add(new HistoryLine(firstNumber, operand, secondNumber, resultNumber));
    }


    public void clearHistory() {
        this.history.clear();
    }

}
