package br.com.otavio.restwithspringbootandjavaerudio.controllers;

import br.com.otavio.restwithspringbootandjavaerudio.services.CalculatorService;
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
    @ResponseBody
    public Double sumValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.sumValues(listNumbers);
    }

    @GetMapping("/sub/{baseValue}")
    @ResponseBody
    public Double subtractValues(@RequestBody ArrayList<Double> listNumbers, @PathVariable Double baseValue){
        return calculatorService.subtractValues(listNumbers, baseValue);
    }

    @GetMapping("/mult")
    @ResponseBody
    public Double multiplyValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.multiplyValues(listNumbers);
    }

    @GetMapping("/div/{baseValue}")
    @ResponseBody
    public Double divideValues(@RequestBody ArrayList<Double> listNumbers, @PathVariable Double baseValue){
        return calculatorService.divideValues(listNumbers, baseValue);
    }

    @GetMapping("/media")
    @ResponseBody
    public Double mediaValues(@RequestBody ArrayList<Double> listNumbers){
        return calculatorService.mediaValues(listNumbers);
    }


    @GetMapping("/root/{baseValue}")
    @ResponseBody
    public Double rootValues(@RequestBody Double number, @PathVariable Double baseValue){
        return calculatorService.rootValues(number, baseValue);
    }
}
