package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.Stack;

public interface Operation {
    void evaluate(Stack<Double> operator) throws InvalidExpressionException;
}
