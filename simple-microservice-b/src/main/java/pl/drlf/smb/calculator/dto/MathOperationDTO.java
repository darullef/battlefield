package pl.drlf.smb.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MathOperationDTO
{
    private int number1;
    private int number2;
    private MathOperationType operation;
}
