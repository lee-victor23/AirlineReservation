package com.example.airline_reservation_system.controller;

import com.example.airline_reservation_system.Util.ValidateManageLogic;
import com.example.airline_reservation_system.model.entity.Aircraft;
import sessionbean.AircraftSessionBeanLocal;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AircraftControllerServlet", value = "/AircraftController")
public class AircraftControllerServlet extends HttpServlet {
    @EJB
    private AircraftSessionBeanLocal aircraftBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Aircraft a = aircraftBean.findAircraft(id);
        request.setAttribute("aircraft", a);
        RequestDispatcher req = request.getRequestDispatcher("aircraftsUpdate.jsp");
        req.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aircraft_code = request.getParameter("aircraftCode");
        String range = request.getParameter("range");
        String model = request.getParameter("model");

        PrintWriter out = response.getWriter();
        // this line is to package the whole values into one array string variable -
        // easier just pass one parameter object

        if (ValidateManageLogic.validateManager(request).equals("UPDATE")) {
            Aircraft a = aircraftBean.findAircraft(aircraft_code);
            a.setRange(Integer.parseInt(range));
            a.setModel(model);
            aircraftBean.updateAircraft(a);
        }
        else if (ValidateManageLogic.validateManager(request).equals("DELETE")) {
            Aircraft a = aircraftBean.findAircraft(aircraft_code);
            aircraftBean.deleteAircraft(a);
        } else {
            Aircraft a = new Aircraft();
            a.setId(aircraft_code);
            a.setRange(Integer.parseInt(range));
            a.setModel(model);
            aircraftBean.addAircraft(a);
        }

        ValidateManageLogic.navigateJS(out);
    }
}
