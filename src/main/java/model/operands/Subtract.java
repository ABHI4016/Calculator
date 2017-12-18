package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Subtract implements Operation {
    @Override
    public void evaluate(Stack<Double> operands) throws InvalidExpressionException {
        try{
            Double op1 = operands.pop();
            Double op2 = operands.pop();
            operands.push(op2 - op1);
        }catch(EmptyStackException ex){
            throw new InvalidExpressionException("Stack is empty, while it shouldn't be");
        }
    }
}
