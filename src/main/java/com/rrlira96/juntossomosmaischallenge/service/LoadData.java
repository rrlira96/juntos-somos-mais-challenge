package com.rrlira96.juntossomosmaischallenge.service;

import com.rrlira96.juntossomosmaischallenge.model.Results;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoadData implements ApplicationRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${url.json}")
    private String urlJson;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ResponseEntity<Results> response = restTemplate.getForEntity(urlJson, Results.class);
        UserService.mapUserToUserVo(response.getBody().getResults());
    }
}
