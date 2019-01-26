package com.example.spring.cloud.contract.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public abstract class AbstractMvcTest {

    @Autowired
    private MovieController movieController;

    @Before
    public void setup() throws JsonProcessingException {
        RestAssuredMockMvc.standaloneSetup(movieController);
    }
}