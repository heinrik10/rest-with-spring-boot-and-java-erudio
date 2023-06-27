package br.com.otavio.restwithspringbootandjavaerudio.services;

import br.com.otavio.restwithspringbootandjavaerudio.validators.MathValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculatorService {

    private MathValidator mathValidator;

    public CalculatorService(MathValidator mathValidator) {
        this.mathValidator = mathValidator;
    }

    public Double divideValues(ArrayList<Double> listNumbers, Double baseValue){
        mathValidator.validateCalculatorValues(listNumbers);
        mathValidator.validateDivide(baseValue);
        for(double numbers: listNumbers){
            baseValue /= numbers;
        }
        return baseValue;
    }

    public Double multiplyValues(ArrayList<Double> listNumbers){
        mathValidator.validateCalculatorValues(listNumbers);
        var baseValue = 1.0;
        for(double numbers: listNumbers){
            baseValue *= numbers;
        }
        return baseValue;
    }

    public Double subtractValues(ArrayList<Double> listNumbers, Double baseValue){
        mathValidator.validateCalculatorValues(listNumbers);
        for (double numbers: listNumbers){
            baseValue -= numbers;
        }
        return baseValue;
    }

    public Double sumValues(ArrayList<Double> listNumbers) {
        mathValidator.validateCalculatorValues(listNumbers);
        var baseValue = 0.0;
        for (double numbers: listNumbers) {
            baseValue += numbers;
        }
        return baseValue;
    }

    public Double mediaValues(ArrayList<Double> listNumbers) {
        var media = sumValues(listNumbers);
        return media/listNumbers.size();
    }

    public Double rootValues(Double number, Double baseValue) {
        return Math.pow(number, 1.0 / baseValue);
    }
    
}
