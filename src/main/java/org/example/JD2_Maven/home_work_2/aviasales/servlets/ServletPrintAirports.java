package org.example.JD2_Maven.home_work_2.aviasales.servlets;

import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.AirportPullDao;
import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.api.IAirportDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPrintAirports", value = "/airports")
public class ServletPrintAirports extends HttpServlet {

    private final IAirportDao dao = new AirportPullDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        request.setAttribute("airports",dao.getAll());

        try {
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        context.getRequestDispatcher("/jsp/aviasales/print_airports.jsp").forward(request,response);
    }
}
