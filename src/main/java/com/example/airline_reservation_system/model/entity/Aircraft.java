package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "aircrafts_data", schema = "bookings")

@NamedQueries({
        @NamedQuery(name = "Aircraft.findAllAsc", query = "SELECT a FROM Aircraft a order by a.id ASC"),
        @NamedQuery(name = "Aircraft.findAllDesc", query = "SELECT a FROM Aircraft a order by a.id DESC"),
        @NamedQuery(name = "Aircraft.findbyId", query = "SELECT a FROM Aircraft a WHERE a.id = :id"),
        @NamedQuery(name = "Aircraft.findKeywordAsc", query = "SELECT a FROM Aircraft a WHERE concat(a.id,a.range,a.model) LIKE ?1 order by a.id ASC"),
        @NamedQuery(name = "Aircraft.findKeywordDesc", query = "SELECT a FROM Aircraft a WHERE concat(a.id,a.range,a.model) LIKE ?1 order by a.id DESC")
})
public class Aircraft {
    @Id
    @Column(name = "aircraft_code", nullable = false, length = 3)
    private String id;

    @Column(name = "range", nullable = false)
    private Integer range;

    @Column(name = "model", nullable = false, length = 45)
    private String model;

    @OneToMany(mappedBy = "aircraftsData")
    private Set<Flight> flights = new LinkedHashSet<>();


    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}