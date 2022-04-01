package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bookings", schema = "bookings")
public class Booking {
    @Id
    @Column(name = "book_ref", nullable = false, length = 6)
    private String id;

    @Column(name = "book_date", nullable = false)
    private OffsetDateTime bookDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "bookings",cascade = CascadeType.REMOVE)
    private Set<Ticket> tickets = new LinkedHashSet<>();

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OffsetDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(OffsetDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}