package org.example.JD2_Maven.home_work_2.aviasales.servlets;

import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.AirportPullDao;
import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.api.IAirportDao;
import org.example.JD2_Maven.home_work_2.aviasales.service.FlightsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletShowSearch", value = "/show_search")
public class ServletShowSearch extends HttpServlet {

    private final IAirportDao dao = new AirportPullDao();

    private final FlightsService service = FlightsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        request.setAttribute("airports",dao.getAll());

        service.getSb().setLength(0);

        context.getRequestDispatcher("/jsp/aviasales/race_form.jsp").forward(request,response);
    }
}
