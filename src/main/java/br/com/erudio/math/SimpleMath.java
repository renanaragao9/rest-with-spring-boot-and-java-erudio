package br.com.erudio.math;

public class SimpleMath {

    public Double sum(
        Double numberOne,
        Double numberTwo
    ) {
    
        return numberOne + numberTwo;
    }

    public Double subtraction(
        Double numberOne,
        Double numberTwo
    ) {
        return numberOne - numberTwo;
    }

    public Double multiplication(
        Double numberOne,
        Double numberTwo
    ) {
        return numberOne * numberTwo;
    }

    public Double division(
        Double numberOne,
        Double numberTwo
    ) {
        return numberOne / numberTwo;
    }

    public Double raiz(
        Double numberOne
    ) {
        return Math.sqrt(numberOne);
    }
}
