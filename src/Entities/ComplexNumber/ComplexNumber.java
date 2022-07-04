package Entities.ComplexNumber;

import Entities.Calculator;

public class ComplexNumber {


    private final double realPart;
    private final double imaginaryPart;
    private final String fullNumericalNumber;
    private final String fullVectorNumber;


    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;

        if (imaginaryPart > 0 && realPart != 0) {
            this.fullNumericalNumber = realPart + "+" + imaginaryPart + "i";
        } else if (imaginaryPart < 0 && realPart != 0) {
            this.fullNumericalNumber = realPart + "" + imaginaryPart + "i";
        } else if (imaginaryPart == 0 && realPart != 0) {
            this.fullNumericalNumber = realPart + "";
        } else {
            this.fullNumericalNumber = imaginaryPart + "i";
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
        return fullNumericalNumber;
    }
    public String getFullNumber(Calculator calculator) {
        return calculator.isVectorEnable() ? getFullVectorNumber() : getFullNumericalNumber();
    }
}
