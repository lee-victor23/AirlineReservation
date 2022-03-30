package sessionbean;

import com.example.airline_reservation_system.model.entity.Airport;

import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;

@Local
public interface AirportSessionBeanLocal {

    public List<Airport> getAllAirport() throws EJBException;
    public Airport findAirport(String id) throws EJBException;
    public void updateAirport(String[] s) throws EJBException;
    public void deleteAirport(String id) throws EJBException;
    public void addAirport(String[] s) throws EJBException;
}
