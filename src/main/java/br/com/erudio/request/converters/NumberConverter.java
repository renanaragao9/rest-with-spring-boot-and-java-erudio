package br.com.erudio.request.converters;

import br.com.erudio.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        return Double.valueOf(strNumber.replaceAll(",", "."));
    }

    public static boolean isNumeric(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Por favor, forneça um número válido!");
        }

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
