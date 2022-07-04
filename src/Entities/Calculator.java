package Entities;

import Entities.ComplexNumber.ComplexNumber;

public class Calculator {


    private boolean isVectorEnable;

    public Calculator() {
        isVectorEnable = false;
    }



    public ComplexNumber add(ComplexNumber first, ComplexNumber second) {
        double realResult = first.getRealPart() + second.getRealPart();
        double imaginaryResult = first.getImaginaryPart() + second.getImaginaryPart();

        return new ComplexNumber(realResult, imaginaryResult);
    }


    public ComplexNumber subtract(ComplexNumber first, ComplexNumber second) {
        double realResult = first.getRealPart() - second.getRealPart();
        double imaginaryResult = first.getImaginaryPart() - second.getImaginaryPart();

        return new ComplexNumber(realResult, imaginaryResult);
    }


    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        double realResult = (first.getRealPart() * second.getRealPart()) - (first.getImaginaryPart() * second.getImaginaryPart());
        double imaginaryResult = (first.getRealPart() * second.getImaginaryPart()) + (first.getImaginaryPart() * second.getRealPart());

        return new ComplexNumber(realResult, imaginaryResult);
    }


    public ComplexNumber decide(ComplexNumber first, ComplexNumber second) {
        double realResult = ((first.getRealPart() * second.getRealPart()) + (first.getImaginaryPart() * second.getImaginaryPart()))
                /
                ((second.getRealPart() * second.getRealPart()) + (second.getImaginaryPart() * second.getImaginaryPart()));

        double imaginaryResult = ((second.getRealPart() * first.getImaginaryPart()) - (first.getRealPart() * second.getImaginaryPart()))
                /
                ((second.getRealPart() * second.getRealPart()) + (second.getImaginaryPart() * second.getImaginaryPart()));

        return new ComplexNumber(realResult, imaginaryResult);
    }



    public boolean isVectorEnable() {
        return isVectorEnable;
    }


    public void clickSwitch() {
        isVectorEnable = !isVectorEnable;
    }


}

