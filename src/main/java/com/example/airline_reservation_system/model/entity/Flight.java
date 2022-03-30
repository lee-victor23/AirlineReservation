package com.example.airline_reservation_system.model.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "flights", schema = "bookings")

@NamedQueries({
        @NamedQuery(name = "Flight.findAllAsc", query = "SELECT f FROM Flight f order by f.id ASC"),
        @NamedQuery(name = "Flight.findAllDesc", query = "SELECT f FROM Flight f order by f.id DESC"),
        @NamedQuery(name = "Flight.findbyId", query = "SELECT f FROM Flight f WHERE f.id = :id"),
        @NamedQuery(name = "Flight.findKeywordAsc", query = "SELECT f FROM Flight f WHERE concat(f.id,f.flightNo,f.status) LIKE ?1 order by f.id ASC"),
        @NamedQuery(name = "Flight.findKeywordDesc", query = "SELECT f FROM Flight f WHERE concat(f.id,f.flightNo,f.status) LIKE ?1 order by f.id DESC")
})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false)
    private Integer id;

    @Column(name = "flight_no", nullable = false, length = 6)
    private String flightNo;

    @Column(name = "scheduled_departure", nullable = false)
    private Timestamp scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private Timestamp scheduledArrival;

    @OneToOne
    @ManyToOne
    @JoinColumn(name = "departure_airport", nullable = false)
    private Airport airportsData;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", nullable = false)
    private Airport airportsData1;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraftsData;

    @Column(name = "actual_departure")
    private Timestamp actualDeparture;

    @Column(name = "actual_arrival")
    private Timestamp actualArrival;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Timestamp getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(Timestamp scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public Timestamp getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(Timestamp scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public Airport getAirportsData() {
        return airportsData;
    }

    public void setAirportsData(Airport airportsData) {
        this.airportsData = airportsData;
    }

    public Airport getAirportsData1() {
        return airportsData1;
    }

    public void setAirportsData1(Airport airportsData1) {
        this.airportsData1 = airportsData1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aircraft getAircraftsData() {
        return aircraftsData;
    }

    public void setAircraftsData(Aircraft aircraftsData) {
        this.aircraftsData = aircraftsData;
    }

    public Timestamp getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(Timestamp actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public Timestamp getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Timestamp actualArrival) {
        this.actualArrival = actualArrival;
    }
}