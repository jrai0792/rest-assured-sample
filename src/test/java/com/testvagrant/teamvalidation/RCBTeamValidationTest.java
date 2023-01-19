package com.testvagrant.teamvalidation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.testvagrant.BaseAPITest;
import com.testvagrant.client.RCBClient;
import com.testvagrant.model.Team;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RCBTeamValidationTest extends BaseAPITest {

    private final RCBClient client = new RCBClient();


    @Test
    void atLeastOneKeeperTest() throws JsonProcessingException {
        final Response response = client.getTeamDetails();
        final Team rcb = objectMapper.readValue(response.getBody().prettyPrint(), Team.class);

        assertAll(
                () -> assertEquals(200, response.getStatusCode()),
                () -> assertEquals(1, rcb.getPlayer()
                        .stream()
                        .filter(player -> player.getRole().equalsIgnoreCase("Wicket-keeper"))
                        .count()));

    }

    @Test
    void maximumFourForeignPlayersTest() throws JsonProcessingException {
        final Response response = client.getTeamDetails();
        final Team rcb = objectMapper.readValue(response.getBody().prettyPrint(), Team.class);

        assertAll(
                () -> assertEquals(200, response.getStatusCode()),
                () -> assertTrue( rcb.getPlayer()
                        .stream()
                        .filter(player -> !player.getCountry().equalsIgnoreCase("India"))
                        .count()<= 4));

    }
}
