package Entities.History;

import Entities.ComplexNumber.ComplexNumber;

public class HistoryLine {


    private ComplexNumber firstNumber;
    private ComplexNumber secondNumber;



    private ComplexNumber resultNumber;
    private String operand;


    public HistoryLine(ComplexNumber firstNumber, String operand, ComplexNumber secondNumber, ComplexNumber resultNumber) {
        this.firstNumber = firstNumber;
        this.operand = operand;
        this.secondNumber = secondNumber;
        this.resultNumber = resultNumber;
    }


    public ComplexNumber getResultNumber() {
        return resultNumber;
    }


    public String getOperand() {
        return operand;
    }


    public String getNumericalLine() {
        return this.firstNumber.getFullNumericalNumber() + " " + this.operand + " " + this.secondNumber.getFullNumericalNumber() + " = " + this.resultNumber.getFullNumericalNumber();
    }

    public String getVectorLine() {
        return this.firstNumber.getFullVectorNumber() + " " + this.operand + " " + this.secondNumber.getFullVectorNumber() + " = " + this.resultNumber.getFullVectorNumber();
    }
}
