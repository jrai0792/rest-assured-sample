package com.testvagrant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    public String name;
    public String country;
    public String role;
    @JsonProperty("price-in-crores")
    public String priceInCrores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPriceInCrores() {
        return priceInCrores;
    }

    public void setPriceInCrores(String priceInCrores) {
        this.priceInCrores = priceInCrores;
    }
}
