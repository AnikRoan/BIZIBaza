package org.example.config;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import  java.sql.Timestamp;



@Entity
@Data
public class City {
    @Id
    @Column(name =" city_id")
    private  Integer id;
    @Column(name ="city")
    private  String name;
    @Column(name="country_id")
    private String country;
    @Column(name ="last_update")
    private  Timestamp update;

}
