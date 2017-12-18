package main.test;

import main.java.Calculator;
import main.java.exceptions.InvalidExpressionException;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;


    @Test
    public void testCalculator() throws InvalidExpressionException{
        this.calculator = new Calculator();
        assert calculator.calculate("1 2 3 + -").getValue() == -4;
        assert calculator.calculate("6 2 * 3 /").getValue() == 4;
        assert calculator.calculate("2 3 ^ 4 5 + +").getValue() == 17;
        assert calculator.calculate("5 1 2 + 4 * + 3 - ").getValue() == 14;
        assert calculator.calculate("5 1 + 2 / !").getValue() == 6;
        assert calculator.calculate("5 !").getValue() == 120;
        assert calculator.calculate("5.0 !").getValue() == 120;

        try {
            calculator.calculate("2 +");
            assert false;
        }catch (InvalidExpressionException opex ){
            assert opex.getMessage().contains("Stack is empty");
        }

        try {
            calculator.calculate("2 2 A");
            assert false;
        }catch (InvalidExpressionException ex ){
            assert ex.getMessage().contains("Operation undefined");
        }


        try {
            calculator.calculate("2.5 !");
            assert false;
        }catch (InvalidExpressionException ex ){
            assert ex.getMessage().contains("Factorial of decimal is non calculable");
        }
    }
}
