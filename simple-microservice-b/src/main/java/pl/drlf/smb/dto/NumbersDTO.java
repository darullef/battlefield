package pl.drlf.smb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumbersDTO
{
    private int number1;
    private int number2;

    @Override
    public String toString()
    {
        return "number1: " + number1 + ", number2: " + number2;
    }
}
