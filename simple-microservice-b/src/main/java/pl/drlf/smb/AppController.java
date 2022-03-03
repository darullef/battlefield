package pl.drlf.smb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.drlf.smb.dto.NumbersDTO;
import pl.drlf.smb.dto.ResultDTO;

@Slf4j
@RestController
@RequestMapping("/api/msb")
public class AppController
{
    private final AppRestTemplate restTemplate;

    @Autowired
    public AppController(AppRestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/division")
    ResponseEntity<ResultDTO> division()
    {
        log.info("***********************************");
        log.info("Incoming request from user");
        log.info("Sending GET request for division result to SMA");
        ResultDTO result = restTemplate.getDivisionResult("/division");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/addition")
    ResponseEntity<ResultDTO> addition(@RequestBody NumbersDTO numbersDTO)
    {
        log.info("***********************************");
        log.info("Incoming request from user");
        log.info(numbersDTO.toString());
        log.info("Sending POST request for addition result to SMA");
        ResultDTO result = restTemplate.getAdditionResult("/addition", numbersDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
