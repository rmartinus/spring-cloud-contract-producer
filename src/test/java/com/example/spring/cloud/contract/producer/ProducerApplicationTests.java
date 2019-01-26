package com.example.spring.cloud.contract.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8081)
public class ProducerApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() throws JsonProcessingException {
        WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/movie/1"))
                        .willReturn(WireMock.aResponse()
                                .withBody(objectMapper.writeValueAsString(new Movie("1", "fav movie", "thriller", "2018")))
                                .withStatus(200))
        );
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081/movie/1", String.class);
        BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(entity.getBody()).isEqualTo(objectMapper.writeValueAsString(new Movie("1", "fav movie", "thriller", "2018")));
    }
}