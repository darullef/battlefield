package pl.drlf.sma.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.drlf.sma.calculator.dto.MathOperationDTO;
import pl.drlf.sma.calculator.dto.MathResultDTO;

@Slf4j
@RestController
@RequestMapping("/api/msa")
public class CalculatorController
{
    private final Calculator calculator;

    @Autowired
    public CalculatorController(Calculator calculator)
    {
        this.calculator = calculator;
    }

    @PostMapping("/calculator")
    ResponseEntity<MathResultDTO> doMath(@RequestBody MathOperationDTO mathOperationDTO)
    {
        try
        {
            int result = calculator.calculate(mathOperationDTO.getNumber1(), mathOperationDTO.getNumber2(), mathOperationDTO.getOperation());
            MathResultDTO mathResultDTO = new MathResultDTO(result);
            return new ResponseEntity<>(mathResultDTO, HttpStatus.OK);
        }
        catch (CalculatorException e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
