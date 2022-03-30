package com.example.airline_reservation_system.controller;

import com.example.airline_reservation_system.model.entity.Aircraft;
import sessionbean.AircraftSessionBeanLocal;

import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AircraftServlet", value = "/Aircraft")
public class AircraftPaginationServlet extends HttpServlet {
    @EJB
    private AircraftSessionBeanLocal aircraftBean;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nOfPages= 0;
        int currentPage = Integer.valueOf(req.getParameter("currentPage"));
        int recordsPerPage = Integer.valueOf(req.getParameter("recordsPerPage"));
        String keyword = req.getParameter("keyword");
        String direction = req.getParameter("direction");

        int rows = aircraftBean.getNumberOfRows(keyword);
        nOfPages = rows / recordsPerPage;
        if (rows % recordsPerPage != 0) {
            nOfPages++;
        }
        if (currentPage > nOfPages && nOfPages != 0) {
            currentPage = nOfPages;
        }

        List<Aircraft> lists = aircraftBean.readAircraft(currentPage, recordsPerPage,keyword, direction);
        req.setAttribute("aircraft", lists);

        req.setAttribute("nOfPages", nOfPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("recordsPerPage", recordsPerPage);
        req.setAttribute("keyword", keyword);
        req.setAttribute("direction", direction);


        RequestDispatcher dispatcher = req.getRequestDispatcher("aircrafts.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
