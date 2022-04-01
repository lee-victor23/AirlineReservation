package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "airports_data", schema = "bookings")
@NamedQueries({
        @NamedQuery(name = "Airport.findAll", query = "SELECT f FROM Airport f"),
        @NamedQuery(name = "Airport.findbyId", query = "SELECT f FROM Airport f WHERE f.id = :id"),
})

public class Airport {
    @Id
    @Column(name = "airport_code", nullable = false, length = 3)
    private String id;

    @Column(name = "timezone", nullable = false)
    private String timezone;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "airport_name", length = 80)
    private String airportName;

    @OneToMany(mappedBy = "airportsData",cascade = CascadeType.REMOVE)
    private Set<Flight> flight = new LinkedHashSet<>();

    @OneToMany(mappedBy = "airportsData1",cascade = CascadeType.REMOVE)
    private Set<Flight> flights = new LinkedHashSet<>();

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public Set<Flight> getFlight() {
        return flight;
    }

    public void setFlight(Set<Flight> flight) {
        this.flight = flight;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}