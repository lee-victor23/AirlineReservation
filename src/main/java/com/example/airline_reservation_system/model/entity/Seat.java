package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "seats", schema = "bookings")
@NamedQueries({
        @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
        @NamedQuery(name = "Seat.findbyId", query = "SELECT s FROM Seat s WHERE s.id = :id"),
        @NamedQuery(name = "Seat.findbyAircraftCode", query = "SELECT s FROM Seat s WHERE s.id.aircraftCode = :id")
})
public class Seat {
    @EmbeddedId
    private SeatId id;

    @MapsId("aircraftCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_code", nullable = false)
    private Aircraft aircraftCode;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public Aircraft getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(Aircraft aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public SeatId getId() {
        return id;
    }

    public void setId(SeatId id) {
        this.id = id;
    }
}