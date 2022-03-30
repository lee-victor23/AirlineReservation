package sessionbean;


import com.example.airline_reservation_system.model.entity.Seat;
import com.example.airline_reservation_system.model.entity.SeatId;

import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;


@Local
public interface SeatSessionBeanLocal {

    public Seat findSeat(SeatId seatId) throws EJBException;

    public List<SeatId> findSeatByAircraftCode (String aircraft_id) throws EJBException;

    public void updateSeat(Seat seat) throws EJBException;

    public void deleteSeat(Seat seat) throws EJBException;

    public void addSeat(Seat seat) throws EJBException;
}
