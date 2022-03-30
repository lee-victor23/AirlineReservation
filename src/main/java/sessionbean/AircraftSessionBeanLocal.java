package sessionbean;

import com.example.airline_reservation_system.model.entity.Aircraft;
import com.example.airline_reservation_system.model.entity.Flight;

import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;
@Local
public interface AircraftSessionBeanLocal {

    public List<Aircraft> getAllAircraft() throws EJBException;

    public Aircraft findAircraft(String aircraft_id) throws EJBException;

    public Flight getRelatedFlights(Aircraft aircraft) throws EJBException;

    public List<Aircraft> readAircraft(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException;

    public int getNumberOfRows(String keyword) throws EJBException ;

    public void updateAircraft(Aircraft a) throws EJBException;

    public void deleteAircraft(Aircraft a) throws EJBException;

    public void addAircraft(Aircraft a) throws EJBException;

}
