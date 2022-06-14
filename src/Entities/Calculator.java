package Entities;

import java.util.ArrayList;

public class Calculator {


    public ComplexNumber add(ComplexNumber first, ComplexNumber second) {

        double realResult = first.getRealPart() + second.getRealPart();
        double imaginaryResult = first.getImaginaryPart() + second.getImaginaryPart();
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);

        return result;
    }


    public ComplexNumber subtract(ComplexNumber first, ComplexNumber second) {
        double realResult = first.getRealPart() - second.getRealPart();
        double imaginaryResult = first.getImaginaryPart() - second.getImaginaryPart();
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);

        return result;
    }


    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        double realResult = ( first.getRealPart() * second.getRealPart() ) - ( first.getImaginaryPart() * second.getImaginaryPart() );
        double imaginaryResult = ( first.getRealPart() * second.getImaginaryPart() ) + ( first.getImaginaryPart() * second.getRealPart() );
        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);

        return result;
    }


    public ComplexNumber decide(ComplexNumber first, ComplexNumber second) {
        double realResult = ( ( first.getRealPart() * second.getRealPart() ) + ( first.getImaginaryPart() * second.getImaginaryPart() ) )
                /
                ( ( second.getRealPart() * second.getRealPart() ) + ( second.getImaginaryPart() * second.getImaginaryPart() ) );

        double imaginaryResult = ( ( second.getRealPart() * first.getImaginaryPart() ) - ( first.getRealPart() * second.getImaginaryPart() ) )
                /
                ( ( second.getRealPart() * second.getRealPart() ) + ( second.getImaginaryPart() * second.getImaginaryPart() ) );

        ComplexNumber result = new ComplexNumber(realResult, imaginaryResult);

        return result;
    }

}
