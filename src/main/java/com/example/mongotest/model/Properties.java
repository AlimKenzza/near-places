package com.example.mongotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties {
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private String category;

    public Properties(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Properties() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
