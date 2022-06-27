package Entities.ComplexNumber;

import Entities.Calculator;

public class ComplexNumber {


    private double realPart;
    private double imaginaryPart;
    private final String imaginaryUnit = "i";
    private String fullNumericalNumber;
    private String fullVectorNumber;


    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;

        if (imaginaryPart > 0 && realPart != 0) {
            this.fullNumericalNumber = realPart + "+" + imaginaryPart + imaginaryUnit;
        } else if (imaginaryPart < 0 && realPart != 0) {
            this.fullNumericalNumber = realPart + "" + imaginaryPart + imaginaryUnit;
        } else if (imaginaryPart == 0 && realPart != 0) {
            this.fullNumericalNumber = String.valueOf(realPart);
        } else if (realPart == 0) {
            this.fullNumericalNumber = String.valueOf(imaginaryPart) + imaginaryUnit;
        }

        fullVectorNumber = "(" + realPart + ", " + imaginaryPart + ")";
    }


    public double getRealPart() {
        return realPart;
    }
    public double getImaginaryPart() {
        return imaginaryPart;
    }
    public String getFullVectorNumber() { return fullVectorNumber; }
    public String getFullNumericalNumber() {
        if (Calculator.isVectorEnable() == false) {
            return fullNumericalNumber;
        } else {
            return fullVectorNumber;
        }
    }
}
