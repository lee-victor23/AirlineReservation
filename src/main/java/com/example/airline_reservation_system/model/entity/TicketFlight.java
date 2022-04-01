package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ticket_flights", schema = "bookings")
public class TicketFlight {
    @EmbeddedId
    private TicketFlightId id;

    @MapsId("ticketNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_no", nullable = false)
    private Ticket ticketNo;

    @MapsId("flightId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ticketFlights",cascade = CascadeType.REMOVE)
    private BoardingPass boardingPasses;

    public BoardingPass getBoardingPasses() {
        return boardingPasses;
    }

    public void setBoardingPasses(BoardingPass boardingPasses) {
        this.boardingPasses = boardingPasses;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Ticket getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Ticket ticketNo) {
        this.ticketNo = ticketNo;
    }

    public TicketFlightId getId() {
        return id;
    }

    public void setId(TicketFlightId id) {
        this.id = id;
    }
}