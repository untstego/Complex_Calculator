package Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HistoryTeller {


    public void tellAllHistory(HistoryMaker historyMaker) {
        for (String string : historyMaker.getHistory()) {
            System.out.println(string);
        }
    }


    public void tellResultsHistory(HistoryMaker historyMaker) {
        String[] temp = new String[2];
        for (String string : historyMaker.getHistory()) {
            temp = string.split(" = ");
            System.out.println(temp[1]);
        }
    }

    public void tellOperandsHistory(HistoryMaker historyMaker) {

        Pattern operandsPattern = Pattern.compile("\\s\\W\\s");

        for (String string : historyMaker.getHistory()) {
            Matcher operandsMatcher = operandsPattern.matcher(string);
            if (operandsMatcher.find()) {
                System.out.println(operandsMatcher.group());
            }
        }


    }
}
