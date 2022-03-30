package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;

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

    @Column(name = "coordinates", nullable = false)
    private String coordinates;

    @Column(name = "timezone", nullable = false)
    private String timezone;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "airport_name", length = 80)
    private String airportName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}


    select f from Flight f left join fetch f.arrivalAirport
        left join fetch f.departureAirport
        left join fetch f.aircraftsData
        order by f.id