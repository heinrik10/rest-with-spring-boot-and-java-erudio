package br.com.otavio.restwithspringbootandjavaerudio.Controller;

import br.com.otavio.restwithspringbootandjavaerudio.Models.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController()
@RequestMapping("/greetings")
public class GeetingsController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World") String name){
        String template = "Hello, %s!";
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
