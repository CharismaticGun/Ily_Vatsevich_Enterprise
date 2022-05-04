package org.example.JD2_Maven.home_work_2.aviasales.servlets;

import org.example.JD2_Maven.home_work_2.aviasales.dao_flights.FlightsPullDao;
import org.example.JD2_Maven.home_work_2.aviasales.service.FlightsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletSearchResult", value = "/flights")
public class ServletSearchResult extends HttpServlet {

    private final FlightsService service = FlightsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        service.setParam(request);

        List<String[]> flights;

        int page = 1;

        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        try(FlightsPullDao dao = new FlightsPullDao()) {
            flights = dao.addFlights((page-1)*25);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("flights",flights);
        request.setAttribute("currentPage",page);

        ServletContext context = request.getServletContext();

        context.getRequestDispatcher("/jsp/db/info_after_form.jsp").forward(request,response);

    }
}
