package com.example.airline_reservation_system.controller;

import com.example.airline_reservation_system.model.entity.Aircraft;
import com.example.airline_reservation_system.model.entity.Flight;
import sessionbean.AircraftSessionBeanLocal;
import sessionbean.FlightsSessionBeanLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowListServlet", value = "/ShowListServlet")
public class ShowListServlet extends HttpServlet {
    @EJB
    AircraftSessionBeanLocal aircraftBean;

    @EJB
    FlightsSessionBeanLocal flightBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("entity").equals("aircraft")){

            String id=request.getParameter("id");

            Aircraft a=aircraftBean.findAircraft(id);

            request.setAttribute("aircraft", a);
            RequestDispatcher dispatcher = request.getRequestDispatcher("aircraft_info.jsp");
            dispatcher.forward(request, response);
        }else if(request.getParameter("entity").equals("flight")){
            String id=request.getParameter("id");

            List<Flight> list=flightBean.getFlightsFromAircraft(id);
            request.setAttribute("flights", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("flights_info.jsp");
            dispatcher.forward(request, response);


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
