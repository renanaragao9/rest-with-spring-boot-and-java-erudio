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

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
       @PathVariable("numberOne") String numberOne,
       @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
       @PathVariable("numberOne") String numberOne,
       @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
       @PathVariable("numberOne") String numberOne,
       @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/raiz/{numberOne}/{numberTwo}")
    public Double raiz(
       @PathVariable("numberOne") String numberOne,
       @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return Math.sqrt(convertToDouble(numberOne));
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
