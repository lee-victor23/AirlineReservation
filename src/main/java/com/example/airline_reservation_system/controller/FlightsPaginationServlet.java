package com.example.airline_reservation_system.controller;


import com.example.airline_reservation_system.model.entity.Flight;
import sessionbean.FlightsSessionBeanLocal;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightsPaginationServlet", value = "/Flights")
public class FlightsPaginationServlet extends HttpServlet {
    @EJB
    private FlightsSessionBeanLocal flightsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nOfPages= 0;
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(request.getParameter("recordsPerPage"));
        String keyword = request.getParameter("keyword");
        String direction = request.getParameter("direction");


        int rows = flightsBean.getNumberOfRows(keyword);
        nOfPages = rows / recordsPerPage;
        if (rows % recordsPerPage != 0) {
            nOfPages++;
        }
        if (currentPage > nOfPages && nOfPages != 0) {
            currentPage = nOfPages;
        }

        List<Flight> lists = flightsBean.readFlight(currentPage, recordsPerPage, keyword, direction);
        request.setAttribute("flight", lists);



        request.setAttribute("nOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("keyword", keyword);
        request.setAttribute("direction", direction);


        RequestDispatcher dispatcher = request.getRequestDispatcher("flights.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
