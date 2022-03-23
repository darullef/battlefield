package pl.drlf.smb.calculator;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import pl.drlf.smb.calculator.dto.MathOperationDTO;
import pl.drlf.smb.calculator.dto.MathResultDTO;
import pl.drlf.smb.rest.AppRestTemplate;

import java.net.URI;

@Service
public class CalculatorService
{
    private static final String MSA_CALCULATOR_URL = "http://localhost:8081/api/msa/calculator";

    private final AppRestTemplate restTemplate;

    public CalculatorService(AppRestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    MathResultDTO calculate(MathOperationDTO mathOperationDTO)
    {
        URI methodUri = UriComponentsBuilder.fromHttpUrl(MSA_CALCULATOR_URL)
            .buildAndExpand()
            .toUri();

        return restTemplate.post(methodUri, mathOperationDTO, MathResultDTO.class);
    }
}
