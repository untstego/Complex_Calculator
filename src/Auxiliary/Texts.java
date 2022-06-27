package Auxiliary;

import Entities.Calculator;

public class Texts {
    public static void crossroad() {
        System.out.println("Type of writing numbers: " + (Calculator.isVectorEnable() == true ? "vector" : "numeric") + "\n");

        System.out.println("Select an action:");
        System.out.println("\t enter number \n" +
                "\t add \n" +
                "\t subtract \n" +
                "\t multiply \n" +
                "\t decide \n" +
                "\t show history \n" +
                "\t show results history \n" +
                "\t show operands history \n" +
                "\t change the number entry type \n" +
                "\t clear \n" +
                "\t exit \n");
    }

    public static void warningClearingHist() {
        System.out.println("You are sure? \n" +
                "The calculation history will be cleared \n" +
                "and the number will be deleted");
    }
}
