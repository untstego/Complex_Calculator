package Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {


    private double realPart;
    private double imaginaryPart;
    private final String imaginaryUnit = "i";
    private String fullNumber;
    static Pattern imaginaryPartPattern = Pattern.compile("\\-?\\d+i");
    static Pattern realPartPattern = Pattern.compile("\\-?\\d+");
    static Pattern unitPattern = Pattern.compile("\\-?i");




    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;


        if (imaginaryPart > 0 && realPart != 0) {
            this.fullNumber = realPart + "+" + imaginaryPart + imaginaryUnit;
        } else if (imaginaryPart < 0 && realPart != 0) {
            this.fullNumber = realPart + "" + imaginaryPart + imaginaryUnit;
        } else if (imaginaryPart == 0 && realPart != 0) {
            this.fullNumber = String.valueOf(realPart);
        } else if (realPart == 0) {
            this.fullNumber = String.valueOf(imaginaryPart) + imaginaryUnit;
        }


    }





    public static ComplexNumber defineComplexNumber(String string) {
        string = string.replaceAll("\\s", "");

        double realPart = 0;
        double imaginaryPart = 0;

        Matcher imaginaryPartMatcher = imaginaryPartPattern.matcher(string);
        while (imaginaryPartMatcher.find()) {
            String temp = imaginaryPartMatcher.group();
            temp = temp.replaceAll("i", "");
            imaginaryPart += Double.parseDouble(temp);
            string = string.replaceAll(temp, "");
        }

        Matcher realPartMatcher = realPartPattern.matcher(string);
        while (realPartMatcher.find()) {
            String temp = realPartMatcher.group();
            realPart += Double.parseDouble(temp);
        }

        Matcher unitMatcher = unitPattern.matcher(string);
        if (unitMatcher.find()) {
            imaginaryPart = 1;
        }

        return new ComplexNumber(realPart, imaginaryPart);
    }




    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }




    public double getRealPart() {
        return realPart;
    }
    public double getImaginaryPart() {
        return imaginaryPart;
    }
    public String getFullNumber() {
        return fullNumber;
    }
}
