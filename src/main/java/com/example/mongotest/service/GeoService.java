package com.example.mongotest.service;

import com.example.mongotest.model.Zagreb;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.bson.conversions.Bson;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Filters.near;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Projections.excludeId;

@Service
public class GeoService {
    private final MongoClient mongoClient;


    public GeoService() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    public List<Zagreb> getNearLocations(Double latitude, Double longtitude) {
        List<Zagreb> zagrebList = new ArrayList<>();
//        Query q=new Query(Criteria.where("id").ne(null));
        //longitude          //latitude
//        NearQuery n = NearQuery.near(new GeoJsonPoint(longtitude, latitude));
//        n.spherical(true);
//        n.inKilometers();
//        n.maxDistance(1); //16 kms
//        n.num(10); //return only 10 objects
//        n.query(q);
        MongoDatabase database = mongoClient.getDatabase("near-places");
        MongoCollection<Document> collection = database.getCollection("zagreb");
        Point currentLoc = new Point(new Position(15.976337, 45.816660));
        Bson query = near("geometry", currentLoc, 100.0, 0.0);
        Bson projection = fields(include("properties.name", "properties.category", "geometry.coordinates"), excludeId());
        ObjectMapper objectMapper = new ObjectMapper();
        collection.find(query)
                .projection(projection)
                .forEach(doc -> {
                    try {
                        zagrebList.add(objectMapper.readValue(doc.toJson(), Zagreb.class));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
        return zagrebList;
    }
}
