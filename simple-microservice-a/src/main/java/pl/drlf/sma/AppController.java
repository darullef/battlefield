package pl.drlf.sma;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.drlf.sma.dto.NumbersDTO;
import pl.drlf.sma.dto.ResultDTO;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/msa")
public class AppController
{
    @GetMapping("/division")
    ResponseEntity<ResultDTO> division(HttpServletRequest request)
    {
        log.info("***********************************");
        log.info("Incoming request from SMB: " + request.getLocalAddr() + ":" +request.getLocalPort());
        int sum = Calculator.division();
        ResultDTO result = new ResultDTO(sum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/addition")
    ResponseEntity<ResultDTO> addition(HttpServletRequest request, @RequestBody NumbersDTO numbersDTO)
    {
        log.info("***********************************");
        log.info("Incoming request from SMB: " + request.getLocalAddr() + ":" +request.getLocalPort());
        int sum = Calculator.addition(numbersDTO.getNumber1(), numbersDTO.getNumber2());
        ResultDTO result = new ResultDTO(sum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
