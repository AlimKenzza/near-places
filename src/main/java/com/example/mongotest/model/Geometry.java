package com.example.mongotest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Geometry {
    @JsonProperty("coordinates")
    private List<Double> coordinates;

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }


}
