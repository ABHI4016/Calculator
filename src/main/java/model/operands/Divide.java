package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Divide implements Operation {
    @Override
    public void evaluate(Stack<Double> operands) throws InvalidExpressionException {
        try{
            Double op1 = operands.pop();
            Double op2 = operands.pop();
            if(op2 == 0){
                throw new InvalidParameterException("Zero found in divisor");
            }
            operands.push( op2 / op1);
        }catch(EmptyStackException ex) {
            throw new InvalidExpressionException("Stack is empty, while it shouldn't be");
        }catch(InvalidParameterException invalidParameter){
            throw new InvalidExpressionException(invalidParameter.getMessage());
        }
    }
}
