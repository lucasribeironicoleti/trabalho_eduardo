package br.com.lucasribeironicoleti.calculator.controller;

import br.com.lucasribeironicoleti.calculator.exceptions.InvalidNumberOperationException;
import br.com.lucasribeironicoleti.calculator.model.Calculator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//..defina esta classe como RestController
@RestController
public class CalculatorController {

    //define um mapeamento de solicitação, usando URL amigável com o método Path Variable sand GET
    @RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
    public float sum(@PathVariable("n1")String n1, @PathVariable("n2")String n2 ){
        //retprna o resultado
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, defina valores numéricos!");
        }
        return Calculator.sum(Float.parseFloat(n1), Float.parseFloat(n2));
    }
    @RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
    public float sub(@PathVariable("n1")String n1, @PathVariable("n2")String n2 ){
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, defina valores numéricos!");
        }
        return Calculator.sub(Float.parseFloat(n1), Float.parseFloat(n2));
    }
    @RequestMapping(value = "/mult/{n1}/{n2}", method = RequestMethod.GET)
    public float mult(@PathVariable("n1")String n1, @PathVariable("n2")String n2 ){
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, defina valores numéricos!");
        }
        return Calculator.mult(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
    public float div(@PathVariable("n1")String n1, @PathVariable("n2")String n2 ){
        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, defina valores numéricos!");
        }
        if (Float.parseFloat(n2) == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida!");
        }
        return Calculator.div(Float.parseFloat(n1), Float.parseFloat(n2));
    }


    public boolean isNumeric(String value){
        try {
            Float.parseFloat(value);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
