package sessionbean;

import com.example.airline_reservation_system.model.entity.Aircraft;
import com.example.airline_reservation_system.model.entity.Flight;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Stateless
public class FlightsSessionBean implements FlightsSessionBeanLocal{
    @PersistenceContext(unitName = "default")
    EntityManager em;


    @Override
    public List<Flight> getAllFlight() throws EJBException {
        return em.createNamedQuery("Flight.findAllAsc", Flight.class).getResultList();
    }

    @Override
    public Flight findFlight(int flight_id) throws EJBException {
        Query q = em.createNamedQuery("Flight.findbyId");
        q.setParameter("id", flight_id);
        return (Flight) q.getSingleResult();
    }

    @Override
    public List<Flight> getFlightsFromAircraft(String aircraft_id) throws EJBException {
        Query q = em.createNativeQuery("SELECT * FROM bookings.flights WHERE flights.aircraft_code = ?",Flight.class);
        q.setParameter(1, aircraft_id);
        List<Flight> result =q.getResultList();
        return result;
    }


    @Override
    public List<Flight> readFlight(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException {
        Query q = null;
        int start = 0;

        if (keyword.isEmpty() && direction.equals("ASC")) {

            start = 0;
            q = em.createNamedQuery("Flight.findAllAsc", Flight.class);

        }else if (keyword.isEmpty() && direction.equals("DESC")){

            start = 0;
            q = em.createNamedQuery("Flight.findAllDesc", Flight.class);

        } else if (!keyword.isEmpty() && direction.equals("ASC")) {

            start = (currentPage - 1) * recordsPerPage;
            q = em.createNamedQuery("Flight.findKeywordAsc", Flight.class);
            q.setParameter(1, "%" + keyword + "%");

        }else if (!keyword.isEmpty() && direction.equals("DESC")) {

            start = (currentPage - 1) * recordsPerPage;
            q = em.createNamedQuery("Flight.findKeywordDesc", Flight.class);
            q.setParameter(1, "%" + keyword + "%");
        }

        start = currentPage * recordsPerPage - recordsPerPage;
        List<Flight> results = q.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
        return results;

    }



    @Override
    public int getNumberOfRows(String keyword) throws EJBException {
        Query q = null;

        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow FROM bookings.flights");

        } else {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow from bookings.flights WHERE concat(flight_id,flight_no) LIKE ?");
            q.setParameter(1, "%" + keyword + "%");
        }

        BigInteger results = (BigInteger) q.getSingleResult();
        int i = results.intValue();
        return i;
    }

    @Override
    public void updateFlight(Flight f) throws EJBException {
        em.merge(f);
    }

    @Override
    public void deleteFlight(Flight f) throws EJBException {
        em.remove(em.contains(f) ? f : em.merge(f));
    }

    @Override
    public void addFlight(Flight f) throws EJBException {
        em.persist(f);


   }


}
