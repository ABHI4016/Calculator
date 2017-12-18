package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.EmptyStackException;
import java.util.Stack;

public class Multiply implements Operation {
    @Override
    public void evaluate(Stack<Double> operands) throws InvalidExpressionException {
        try{
            operands.push(operands.pop() * operands.pop());
        }catch(EmptyStackException ex){
            throw new InvalidExpressionException("Stack is empty, while it shouldn't be");
        }
    }
}
