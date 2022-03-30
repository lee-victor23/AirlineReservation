package sessionbean;

import com.example.airline_reservation_system.model.entity.Airport;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AirportSessionBean implements AirportSessionBeanLocal{
    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Airport> getAllAirport() throws EJBException {
        return em.createNamedQuery("Airport.findAll", Airport.class).getResultList();
    }

    @Override
    public Airport findAirport(String id) throws EJBException {
        Query q = em.createNamedQuery("Airport.findbyId");
        q.setParameter("id", String.valueOf(id));
        return (Airport) q.getSingleResult();
    }

    @Override
    public void updateAirport(String[] s) throws EJBException {
        Airport a = findAirport(s[0]);

        em.persist(a);
    }

    @Override
    public void deleteAirport(String id) throws EJBException {
        Airport a = findAirport(id);
        em.remove(a);
    }

    @Override
    public void addAirport(String[] s) throws EJBException {
        Airport a=new Airport();

        em.persist(a);
    }
}
