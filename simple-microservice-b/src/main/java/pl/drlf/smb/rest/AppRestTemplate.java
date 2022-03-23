package pl.drlf.smb.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Component
public class AppRestTemplate
{
    private RestTemplate restTemplate;

    public <R> R get(URI uri, Class<R> responseClass)
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

    public <T, R> R post(URI uri, T requestParam, Class<R> responseClass)
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
