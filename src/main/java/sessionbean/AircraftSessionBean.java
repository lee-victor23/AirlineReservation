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
public class AircraftSessionBean implements AircraftSessionBeanLocal {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Aircraft> getAllAircraft() throws EJBException {
        return em.createNamedQuery("Aircraft.findAllAsc", Aircraft.class).getResultList();
    }

    @Override
    public Aircraft findAircraft(String aircraft_id) throws EJBException {
        Query q = em.createNamedQuery("Aircraft.findbyId");
        q.setParameter("id", aircraft_id);
        return (Aircraft) q.getSingleResult();
    }

    @Override
    public Flight getRelatedFlights(Aircraft aircraft) throws EJBException {
        return null;
    }


    @Override
    public List<Aircraft> readAircraft(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException {

        Query q = null;
        int start = 0;

        if (keyword.isEmpty() && direction.equals("ASC")) {

           // start = 0;
            q = em.createNamedQuery("Aircraft.findAllAsc", Aircraft.class);

        } else if (keyword.isEmpty() && direction.equals("DESC")) {

           // start = 0;
            q = em.createNamedQuery("Aircraft.findAllDesc", Aircraft.class);

        } else if (!keyword.isEmpty() && direction.equals("ASC")) {

            //start = (currentPage - 1) * recordsPerPage;
            q = em.createNamedQuery("Aircraft.findKeywordAsc", Aircraft.class);
            q.setParameter(1, "%" + keyword + "%");

        } else if (!keyword.isEmpty() && direction.equals("DESC")) {

            //start = (currentPage - 1) * recordsPerPage;
            q = em.createNamedQuery("Aircraft.findKeywordDesc", Aircraft.class);
            q.setParameter(1, "%" + keyword + "%");
        }

        start = currentPage * recordsPerPage - recordsPerPage;

        List<Aircraft> results = q.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
        return results;

    }

    @Override
    public int getNumberOfRows(String keyword) throws EJBException {
        Query q = null;

        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow FROM bookings.aircrafts_data");
        } else {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow from bookings.aircrafts_data WHERE concat(aircraft_code,range,model) LIKE ?");
            q.setParameter(1, "%" + keyword + "%");
        }

        BigInteger results = (BigInteger) q.getSingleResult();
        int i = results.intValue();
        return i;
    }

    @Override
    public void updateAircraft(Aircraft a) throws EJBException {
        em.merge(a);
    }

    @Override
    public void deleteAircraft(Aircraft a) throws EJBException {
        em.remove(em.contains(a) ? a : em.merge(a));
    }

    @Override
    public void addAircraft(Aircraft a) throws EJBException {
        em.persist(a);
    }
}
