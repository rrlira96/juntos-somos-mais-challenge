package com.rrlira96.juntossomosmaischallenge.service;

import com.rrlira96.juntossomosmaischallenge.model.Results;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoadData implements ApplicationRunner {

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String url = "https://storage.googleapis.com/juntossomosmais-code-challenge/input-backend.json";
        ResponseEntity<Results> response = restTemplate.getForEntity(url, Results.class);
        UserService.mapUserToUserVo(response.getBody().getResults());
    }
}
