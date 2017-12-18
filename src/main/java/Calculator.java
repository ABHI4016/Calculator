package main.java;

import main.java.exceptions.InvalidExpressionException;
import main.java.model.Expression;

public class Calculator {

    public Expression calculate(String expression) throws InvalidExpressionException{
        return new Expression(expression);
    }

}
