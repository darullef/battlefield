package pl.drlf.smb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.drlf.smb.dto.NumbersDTO;
import pl.drlf.smb.dto.ResultDTO;

import java.net.URI;

@Slf4j
@Component
public class AppRestTemplate
{
    private static final String MSA_ULR = "http://localhost:8081/api/msa";
    private RestTemplate restTemplate;

    public ResultDTO getDivisionResult(String url)
    {
        URI methodUri = UriComponentsBuilder.fromHttpUrl(MSA_ULR + url)
            .buildAndExpand()
            .toUri();

        return get(methodUri, ResultDTO.class);
    }

    public ResultDTO getAdditionResult(String url, NumbersDTO numbersDTO)
    {
        URI methodUri = UriComponentsBuilder.fromHttpUrl(MSA_ULR + url)
            .buildAndExpand()
            .toUri();

       return post(methodUri, numbersDTO, ResultDTO.class);
    }

    <R> R get(URI uri, Class<R> responseClass)
    {
        try
        {
            restTemplate = new RestTemplate();
            return restTemplate.getForObject(uri, responseClass);
        }
        catch (Exception ex)
        {
            log.error("Unexpected exception while requesting " + uri);
            throw ex;
        }
    }

    <T, R> R post(URI uri, T requestParam, Class<R> responseClass)
    {
        try
        {
            restTemplate = new RestTemplate();
            ResponseEntity<R> responseEntity = restTemplate.postForEntity(uri, requestParam, responseClass);
            return responseEntity.getBody();
        }
        catch (Exception ex)
        {
            log.error("Unexpected exception while requesting " + uri);
            throw ex;
        }
    }
}
