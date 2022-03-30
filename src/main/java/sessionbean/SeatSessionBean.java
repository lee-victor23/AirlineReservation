package sessionbean;

import com.example.airline_reservation_system.model.entity.Seat;
import com.example.airline_reservation_system.model.entity.SeatId;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class SeatSessionBean implements SeatSessionBeanLocal {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public Seat findSeat(SeatId seatId) throws EJBException {
        Query q = em.createNamedQuery("Seat.findbyId");
        q.setParameter("id",seatId);
        return (Seat) q.getSingleResult();
    }

    @Override
    public List<SeatId> findSeatByAircraftCode(String aircraft_id) throws EJBException {
        Query q = em.createNamedQuery("Seat.findbyAircraftCode");
        q.setParameter("id",aircraft_id);
        return (List<SeatId>) q.getResultList();
    }

    @Override
    public void updateSeat(Seat seat) throws EJBException {
        em.merge(seat);
    }

    @Override
    public void deleteSeat(Seat seat) throws EJBException {
        em.remove(em.contains(seat) ? seat : em.merge(seat));
    }

    @Override
    public void addSeat(Seat seat) throws EJBException {
        em.persist(seat);
    }
}
