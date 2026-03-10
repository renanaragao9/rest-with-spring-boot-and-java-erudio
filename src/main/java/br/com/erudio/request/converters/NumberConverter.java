package br.com.erudio.request.converters;

import br.com.erudio.exception.ResourceNotFoundException;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) throws ResourceNotFoundException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new ResourceNotFoundException("Por favor, forneça um número válido!");
        }

        return Double.valueOf(strNumber.replaceAll(",", "."));
    }

    public static boolean isNumeric(String strNumber) throws ResourceNotFoundException {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new ResourceNotFoundException("Por favor, forneça um número válido!");
        }

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
