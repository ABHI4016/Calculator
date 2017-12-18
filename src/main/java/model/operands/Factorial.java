package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Factorial implements Operation {
    @Override
    public void evaluate(Stack<Double> operands) throws InvalidExpressionException {
        try {
            Double op1 = operands.pop();
            if (op1 - op1.intValue() != 0) {
                throw new InvalidExpressionException("Factorial of decimal is non calculable");
            }
            operands.push(fact(op1.intValue()).doubleValue());
        } catch (EmptyStackException ex) {
            throw  new InvalidExpressionException("Stack is empty, while it shouldn't be");
        }
    }


    private Integer fact(Integer op){
        if(op == 0){
            return 1;
        }else if(op ==1 ){
            return 1;
        }else{
            return op * fact (--op);
        }
    }
}
