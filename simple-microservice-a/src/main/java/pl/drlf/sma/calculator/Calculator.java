package pl.drlf.sma.calculator;

import org.springframework.stereotype.Component;
import pl.drlf.sma.calculator.dto.MathOperationType;

@Component
public class Calculator
{
    public int calculate(int number1, int number2, MathOperationType operation)
    {
        try
        {
            switch (operation)
            {
                case ADDITION:
                    return number1 + number2;
                case SUBTRACTION:
                    return number1 - number2;
                case MULTIPLICATION:
                    return number1 * number2;
                case DIVISION:
                    return number1 / number2;
                default:
                    return 0;
            }
        }
        catch (ArithmeticException e)
        {
            throw new CalculatorException(e.getMessage());
        }
    }
}
