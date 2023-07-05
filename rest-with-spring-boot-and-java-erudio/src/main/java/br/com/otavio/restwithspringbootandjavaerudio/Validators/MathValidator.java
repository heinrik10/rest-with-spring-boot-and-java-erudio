package br.com.otavio.restwithspringbootandjavaerudio.Validators;

import br.com.otavio.restwithspringbootandjavaerudio.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class MathValidator {

    public void validateCalculatorValues(ArrayList<Double> listNumbers) {
        if (Objects.isNull(listNumbers) || listNumbers.isEmpty()){
            throw new ResourceNotFoundException("List is null or empty");
        }
    }

    public void validateDivide(Double value) {
        if (value < 0){
            throw new ResourceNotFoundException("Value is below 0");
        }
    }
}
