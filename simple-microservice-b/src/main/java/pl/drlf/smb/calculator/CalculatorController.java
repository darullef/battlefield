package pl.drlf.smb.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.drlf.smb.calculator.dto.MathOperationDTO;
import pl.drlf.smb.calculator.dto.MathResultDTO;

@Slf4j
@RestController
@RequestMapping("/api/msb")
public class CalculatorController
{
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculator")
    ResponseEntity<MathResultDTO> calculator(@RequestBody MathOperationDTO mathOperationDTO)
    {
        MathResultDTO result = calculatorService.calculate(mathOperationDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
