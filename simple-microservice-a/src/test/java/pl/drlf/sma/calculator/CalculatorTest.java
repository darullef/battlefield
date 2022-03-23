package pl.drlf.sma.calculator;

import org.junit.jupiter.api.Test;
import pl.drlf.sma.calculator.dto.MathOperationType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.drlf.sma.calculator.dto.MathOperationType.ADDITION;
import static pl.drlf.sma.calculator.dto.MathOperationType.DIVISION;
import static pl.drlf.sma.calculator.dto.MathOperationType.MULTIPLICATION;
import static pl.drlf.sma.calculator.dto.MathOperationType.SUBTRACTION;

class CalculatorTest
{
    Calculator calculator = new Calculator();

    @Test
    void additionTest()
    {
        assertEquals(2, calculatorHelper(1, 1, ADDITION));
        assertEquals(0, calculatorHelper(1, -1, ADDITION));
        assertEquals(0, calculatorHelper(-1, 1, ADDITION));
        assertEquals(-2, calculatorHelper(-1, -1, ADDITION));
    }

    @Test
    void subtractionTest()
    {
        assertEquals(0, calculatorHelper(1, 1, SUBTRACTION));
        assertEquals(2, calculatorHelper(1, -1, SUBTRACTION));
        assertEquals(-2, calculatorHelper(-1, 1, SUBTRACTION));
        assertEquals(0, calculatorHelper(-1, -1, SUBTRACTION));
    }

    @Test
    void multiplicationTest()
    {
        assertEquals(1, calculatorHelper(1, 1, MULTIPLICATION));
        assertEquals(-1, calculatorHelper(1, -1, MULTIPLICATION));
        assertEquals(1, calculatorHelper(-1, -1, MULTIPLICATION));
        assertEquals(2, calculatorHelper(1, 2, MULTIPLICATION));

        assertEquals(18, calculatorHelper(2, 9, MULTIPLICATION));
    }

    @Test
    void divisionTest()
    {
        assertEquals(1, calculatorHelper(1, 1, DIVISION));
        assertEquals(-1, calculatorHelper(1, -1, DIVISION));
        assertEquals(-1, calculatorHelper(-1, 1, DIVISION));
        assertEquals(1, calculatorHelper(-1, -1, DIVISION));

        assertEquals(0, calculatorHelper(1, 2, DIVISION));
        assertEquals(2, calculatorHelper(2, 1, DIVISION));

        CalculatorException e = assertThrows(CalculatorException.class, () -> calculatorHelper(1, 0, DIVISION));
        assertEquals("/ by zero", e.getMessage());
    }

    private int calculatorHelper(int a, int b, MathOperationType operation)
    {
        return calculator.calculate(a, b, operation);
    }
}
