package main.java.model;

import main.java.exceptions.InvalidExpressionException;
import main.java.model.operands.OperandFactory;
import main.java.model.operands.Operation;

import java.util.Stack;

public class Expression {
    private String expressionString;
    private Double value;

    public Expression(String expressionString) throws InvalidExpressionException {
        new OperandFactory();
        this.expressionString = expressionString;
        this.value = evaluate();
    }

    public Double getValue() {
        return value;
    }

    private Double evaluate() throws InvalidExpressionException {
        Stack<Double> operands = new Stack<>();
        String[] expressionArray = expressionString.split(" ");

        for (String temp : expressionArray) {
            try {
                operands.push(Double.parseDouble(temp.trim()));
            } catch (Exception ex) {
                evaluate(operands, temp.trim());
            }
        }

        if (operands.size() == 1) {
            return operands.pop();
        } else {
            throw new InvalidExpressionException("Stack size is more than one after evaluation, Invalid expression");
        }
    }

    private void evaluate(Stack<Double> operands, String operator) throws InvalidExpressionException {
        Operation op = OperandFactory.getOperand(operator);
        op.evaluate(operands);
    }
}
