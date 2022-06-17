package Entities;

import java.util.ArrayList;

public class HistoryMaker {

    private ArrayList<String> history = new ArrayList<>();


    public ArrayList<String> getHistory() {
        return history;
    }


    public void addToHistory(String firstNumber, String symbol, String secondNumber, String result) {
        this.history.add(String.format("%s %s %s \t = %s", firstNumber, symbol, secondNumber, result));
    }


    public void clearHistory() {
        this.history.clear();
    }

}
