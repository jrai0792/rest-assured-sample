package com.testvagrant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testvagrant.config.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseAPITest {

    protected static Configuration configuration;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void initialize() throws IOException {
        configuration = Configuration.getInstance();
        baseURI = configuration.baseURI();

    }

}
