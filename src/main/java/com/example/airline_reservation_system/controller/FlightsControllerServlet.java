package com.example.airline_reservation_system.controller;

import com.example.airline_reservation_system.Util.ValidateManageLogic;
import com.example.airline_reservation_system.model.entity.Aircraft;
import com.example.airline_reservation_system.model.entity.Airport;
import com.example.airline_reservation_system.model.entity.Flight;
import sessionbean.AircraftSessionBeanLocal;
import sessionbean.AirportSessionBeanLocal;
import sessionbean.FlightsSessionBeanLocal;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FlightsControllerServlet", value = "/FlightsController")
public class FlightsControllerServlet extends HttpServlet {
    @EJB
    private FlightsSessionBeanLocal flightsBean;
    @EJB
    private AircraftSessionBeanLocal aircraftBean;
    @EJB
    private AirportSessionBeanLocal airportBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Flight fBean = flightsBean.findFlight(Integer.parseInt(id));
            request.setAttribute("flight", fBean);
            RequestDispatcher req = request.getRequestDispatcher("flightsUpdate.jsp");
            req.forward(request, response);
        } catch (EJBException ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Timestamp scheduleDeparture=null;
        Timestamp scheduleArrival=null;
        Timestamp actualDeparture=null;
        Timestamp actualArrival=null;


        int flight_id = Integer.parseInt(request.getParameter("flight_id"));
        String flight_no = request.getParameter("flight_no");
        String status = request.getParameter("status");
        System.out.println(flight_id);
        try {
            scheduleDeparture = parseStringToTimestamp(request.getParameter("scheduled_departure"));
            scheduleArrival = parseStringToTimestamp(request.getParameter("scheduled_arrival"));
            actualDeparture = parseStringToTimestamp(request.getParameter("actual_departure"));
            actualArrival = parseStringToTimestamp(request.getParameter("actual_arrival"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String airportCodeDpt = request.getParameter("departure_airport");
        String airportCodeArr = request.getParameter("arrival_airport");
        String aircraft_code = request.getParameter("aircraft_code");

        Airport departureAirport = airportBean.findAirport(airportCodeDpt);
        Airport arrivalAirport = airportBean.findAirport(airportCodeArr);
        Aircraft aircraft = aircraftBean.findAircraft(aircraft_code);


        if (ValidateManageLogic.validateManager(request).equals("UPDATE")) {
            Flight f = flightsBean.findFlight(flight_id);

            f.setAircraftsData(aircraft);
            f.setFlightNo(flight_no);
            f.setScheduledDeparture(scheduleDeparture);
            f.setScheduledArrival(scheduleArrival);
            f.setAirportsData(departureAirport);
            f.setAirportsData1(arrivalAirport);
            f.setStatus(status);
            f.setActualDeparture(actualDeparture);
            f.setActualArrival(actualArrival);
            f.setAircraftsData(aircraft);

            flightsBean.updateFlight(f);
        } else if (ValidateManageLogic.validateManager(request).equals("DELETE")) {
            Flight f = flightsBean.findFlight(flight_id);
            flightsBean.deleteFlight(f);
        } else {
            Flight f = flightsBean.findFlight(flight_id);

            f.setAircraftsData(aircraft);
            f.setFlightNo(flight_no);
            f.setScheduledDeparture(scheduleDeparture);
            f.setScheduledArrival(scheduleArrival);
            f.setAirportsData(departureAirport);
            f.setAirportsData1(arrivalAirport);
            f.setStatus(status);
            f.setActualDeparture(actualDeparture);
            f.setActualArrival(actualArrival);
            f.setAircraftsData(aircraft);

            flightsBean.addFlight(f);
        }

        PrintWriter out=response.getWriter();;
        out.println("<SCRIPT type=\"text/javascript\">");
        out.println("alert(\"Record has been updated and url will be redirected\")");
        out.println("window.location.assign(\"Flights?currentPage=1&recordsPerPage=70&keyword=&direction=ASC\")");
        out.println("</SCRIPT>");

    }

    public static Timestamp parseStringToTimestamp(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(str);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        return timestamp;
    }
}

