package pjatk.com.rentalservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String findMovieById(Long id){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/movies/" + id, String.class);
        return responseEntity.getBody();
    }

    public void returnMovieById(Long id){
        restTemplate.put("http://localhost:8080/movies/" + id + "/set-available", String.class);
    }
}
