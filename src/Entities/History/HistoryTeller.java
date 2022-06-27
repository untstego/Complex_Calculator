package Entities.History;

import Entities.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HistoryTeller {


    private void tellAllNumericalHistory(HistoryMaker historyMaker) {
        for (HistoryLine historyLine : historyMaker.getHistory()) {
            System.out.println(historyLine.getNumericalLine());
        }
    }


    private void tellNumericalResultsHistory(HistoryMaker historyMaker) {
        for (HistoryLine historyLine : historyMaker.getHistory()) {
            System.out.println(historyLine.getResultNumber().getFullNumericalNumber());
        }
    }


    private void tellAllVectorHistory(HistoryMaker historyMaker) {
        for (HistoryLine historyLine : historyMaker.getHistory()) {
            System.out.println(historyLine.getVectorLine());
        }
    }


    private void tellVectorResultsHistory(HistoryMaker historyMaker) {
        for (HistoryLine historyLine : historyMaker.getHistory()) {
            System.out.println(historyLine.getResultNumber().getFullVectorNumber());
        }
    }


    public void tellOperandsHistory(HistoryMaker historyMaker) {
        for (HistoryLine historyLine : historyMaker.getHistory()) {
            System.out.println(historyLine.getOperand());
        }
    }

    public void tellAllHistory(HistoryMaker historyMaker) {
        if (Calculator.isVectorEnable()) {
            tellAllVectorHistory(historyMaker);
        } else {
            tellAllNumericalHistory(historyMaker);
        }
    }

    public void tellResultsHistory(HistoryMaker historyMaker) {
        if (Calculator.isVectorEnable()) {
            tellVectorResultsHistory(historyMaker);
        } else {
            tellVectorResultsHistory(historyMaker);
        }
    }


}
