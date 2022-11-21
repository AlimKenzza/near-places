package com.example.mongotest.controller;


import com.example.mongotest.model.Zagreb;
import com.example.mongotest.service.GeoService;
import com.example.mongotest.utils.HttpUtils;
import org.springframework.data.geo.GeoResults;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WebController {
    private final HttpUtils httpUtils;
    private final GeoService geoService;

    public WebController(HttpUtils httpUtils, GeoService geoService) {
        this.httpUtils = httpUtils;
        this.geoService = geoService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/geo-find",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<Zagreb> getClientIPAddress(@RequestParam Double latitude, @RequestParam Double longtitude) {
        return geoService.getNearLocations(latitude, longtitude);
    }
}
