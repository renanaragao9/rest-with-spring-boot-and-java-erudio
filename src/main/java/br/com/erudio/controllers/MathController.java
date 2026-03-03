package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")

public class MathController {
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction")
    public Double subtraction(
        Double numberOne, 
        Double numberTwo
    ) {
        return numberOne - numberTwo;
    }

    @RequestMapping("/multiplication")
    public Double multiplication(
        Double numberOne, 
        Double numberTwo
    ) {
        return numberOne * numberTwo;
    }

    @RequestMapping("/division")
    public Double division(
        Double numberOne, 
        Double numberTwo
    ) {
        return numberOne / numberTwo;
    }

    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return Double.valueOf(strNumber.replaceAll(",", "."));
    }

    private boolean isNumeric(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
