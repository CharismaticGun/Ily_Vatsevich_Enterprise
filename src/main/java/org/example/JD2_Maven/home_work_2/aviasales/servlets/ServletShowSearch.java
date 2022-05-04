package org.example.JD2_Maven.home_work_2.aviasales.servlets;

import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.AirportPullDao;
import org.example.JD2_Maven.home_work_2.aviasales.dao_airports.api.IAirportDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletShowSearch", value = "/show_search")
public class ServletShowSearch extends HttpServlet {

    private final IAirportDao dao = new AirportPullDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        request.setAttribute("airports",dao.getAll());

        context.getRequestDispatcher("/jsp/db/race_form.jsp").forward(request,response);
    }
}
