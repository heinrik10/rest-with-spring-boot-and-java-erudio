package br.com.otavio.restwithspringbootandjavaerudio.validators;

import br.com.otavio.restwithspringbootandjavaerudio.exceptions.MathValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class MathValidator {

    public void validateCalculatorValues(ArrayList<Double> listNumbers) {
        if (Objects.isNull(listNumbers) || listNumbers.isEmpty()){
            throw new MathValidationException("List is null or empty");
        }
    }

    public void validateDivide(Double value) {
        if (value < 0){
            throw new MathValidationException("Value is below 0");
        }
    }
}
