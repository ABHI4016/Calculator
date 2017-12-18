package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Percentage implements Operation {
    @Override
    public void evaluate(Stack<Double> operands) throws InvalidExpressionException {
        try{
            Double op1 = operands.pop();
            operands.push((op1) /100);
        }catch(EmptyStackException ex){
            throw new InvalidExpressionException("Stack is empty, while it shouldn't be");
        }
    }
}
