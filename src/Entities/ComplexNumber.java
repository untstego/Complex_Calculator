package Entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber {


    private double realPart;
    private double imaginaryPart;
    private final String imaginaryUnit = "i";
    private String fullNumber;


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
