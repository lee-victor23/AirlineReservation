package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tickets", schema = "bookings")
public class Ticket {
    @Id
    @Column(name = "ticket_no", nullable = false, length = 13)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_ref", nullable = false)
    private Booking bookings;

    @Column(name = "passenger_id", nullable = false, length = 20)
    private String passengerId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @OneToMany(mappedBy = "ticketNo",cascade = CascadeType.REMOVE)
    private Set<TicketFlight> ticketFlights = new LinkedHashSet<>();

    public Set<TicketFlight> getTicketFlights() {
        return ticketFlights;
    }

    public void setTicketFlights(Set<TicketFlight> ticketFlights) {
        this.ticketFlights = ticketFlights;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public Booking getBookings() {
        return bookings;
    }

    public void setBookings(Booking bookings) {
        this.bookings = bookings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}