package com.testvagrant;

import com.testvagrant.config.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class BaseAPITest {

    protected static Configuration configuration;


    @BeforeAll
    public static void initialize() throws IOException {
        configuration = Configuration.getInstance();

        baseURI = configuration.baseURI();
        basePath = configuration.basePath();

    }

}
