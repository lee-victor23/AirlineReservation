package sessionbean;

import com.example.airline_reservation_system.model.entity.Aircraft;
import com.example.airline_reservation_system.model.entity.Flight;

import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;
@Local
public interface FlightsSessionBeanLocal {
    public List<Flight> getAllFlight() throws EJBException;

    public Flight findFlight(int flight_id) throws EJBException;

    public List<Flight> getFlightsFromAircraft(String aircraft_id) throws EJBException;

    public List<Flight> readFlight(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException;

    public int getNumberOfRows(String keyword) throws EJBException ;

    public void updateFlight(Flight f) throws EJBException;

    public void deleteFlight(Flight f) throws EJBException;

    public void addFlight(Flight f) throws EJBException;
}
