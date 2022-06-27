package Entities.ComplexNumber;

import Entities.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberReader {

    static Pattern imaginaryPartPattern = Pattern.compile("\\-?\\d+\\.?\\d?i");
    static Pattern realPartPattern = Pattern.compile("\\-?\\d+\\.?\\d?");
    static Pattern unitPattern = Pattern.compile("\\-?i");


    public ComplexNumber defineNumericComplexNumber(String string) {
        String workString = string.replaceAll("\\s", "");

        double realPart = 0;
        double imaginaryPart = 0;

        Matcher imaginaryPartMatcher = imaginaryPartPattern.matcher(workString);
        while (imaginaryPartMatcher.find()) {
            String temp = imaginaryPartMatcher.group();
            workString = workString.replaceAll(temp, "");
            temp = temp.replaceAll("i", "");
            imaginaryPart += Double.parseDouble(temp);
        }

        Matcher realPartMatcher = realPartPattern.matcher(workString);
        while (realPartMatcher.find()) {
            String temp = realPartMatcher.group();
            realPart += Double.parseDouble(temp);
        }

        Matcher unitMatcher = unitPattern.matcher(workString);
        while (unitMatcher.find()) {
            String temp = unitMatcher.group();
            if (temp.contains("-")) {
                imaginaryPart--;
            } else {
                imaginaryPart++;
            }
        }

        return new ComplexNumber(realPart, imaginaryPart);
    }


    public ComplexNumber defineVectorComplexNumber(String string) {
        double realPart = 0;
        double imaginaryPart = 0;

        String workString = string.replaceAll("\\s", "");
        workString = workString.replaceAll("\\(", "");
        workString = workString.replaceAll("\\)", "");
        String[] temp = new String[2];
        temp = workString.split(",");
        realPart = Double.parseDouble(temp[0]);
        imaginaryPart = Double.parseDouble(temp[1]);

        return new ComplexNumber(realPart, imaginaryPart);
    }


    public ComplexNumber defineComplexNumber(String string) {

        return Calculator.isVectorEnable() ? defineVectorComplexNumber(string) : defineNumericComplexNumber(string);
    }

}
