package Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberReader {

    static Pattern imaginaryPartPattern = Pattern.compile("\\-?\\d+\\.?\\d+i");
    static Pattern realPartPattern = Pattern.compile("\\-?\\d+\\.?\\d?");
    static Pattern unitPattern = Pattern.compile("\\-?i");


    public ComplexNumber defineComplexNumber(String string) {
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

}
