package br.com.otavio.restwithspringbootandjavaerudio.Controller;

import br.com.otavio.restwithspringbootandjavaerudio.Services.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/math")
public class CalculatorController {

    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public Double sumValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.sumValues(listNumbers);
    }

    @GetMapping("/sub/{baseValue}")
    public Double subtractValues(@RequestBody ArrayList<Double> listNumbers, @PathVariable Double baseValue){
        return calculatorService.subtractValues(listNumbers, baseValue);
    }

    @GetMapping("/mult")
    public Double multiplyValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.multiplyValues(listNumbers);
    }

    @GetMapping("/div/{baseValue}")
    public Double divideValues(@RequestBody ArrayList<Double> listNumbers, @PathVariable Double baseValue){
        return calculatorService.divideValues(listNumbers, baseValue);
    }

    @GetMapping("/media")
    public Double mediaValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.mediaValues(listNumbers);
    }


    @GetMapping("/root/{baseValue}")
    public Double rootValues(@RequestBody Double number, @PathVariable Double baseValue){
        return calculatorService.rootValues(number, baseValue);
    }
}