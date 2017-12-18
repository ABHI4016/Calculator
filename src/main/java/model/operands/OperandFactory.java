package main.java.model.operands;

import main.java.exceptions.InvalidExpressionException;

import java.util.HashMap;
import java.util.Map;

public class OperandFactory {
    static  Map<String, Operation> operationMap;

    public OperandFactory(){

        operationMap = new HashMap<>();
        operationMap.put("+" ,new Add());
        operationMap.put("!" ,new Factorial());
        operationMap.put("^" ,new Exponent());
        operationMap.put("/" ,new Divide());
        operationMap.put("*" ,new Multiply());
        operationMap.put("-" ,new Subtract());
    }

    public static Operation getOperand(String op)throws InvalidExpressionException{
        if(!operationMap.containsKey(op)){
            throw new InvalidExpressionException("Operation undefined");
        }
        return operationMap.get(op);
    }
}
