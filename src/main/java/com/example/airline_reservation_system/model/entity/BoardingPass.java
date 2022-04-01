package com.example.airline_reservation_system.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "boarding_passes", schema = "bookings")
public class BoardingPass {
    @EmbeddedId
    private BoardingPassId id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumns({
            @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no", nullable = false),
            @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", nullable = false)
    })
    private TicketFlight ticketFlights;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getBoardingNo() {
        return boardingNo;
    }

    public void setBoardingNo(Integer boardingNo) {
        this.boardingNo = boardingNo;
    }

    public TicketFlight getTicketFlights() {
        return ticketFlights;
    }

    public void setTicketFlights(TicketFlight ticketFlights) {
        this.ticketFlights = ticketFlights;
    }

    public BoardingPassId getId() {
        return id;
    }

    public void setId(BoardingPassId id) {
        this.id = id;
    }
}