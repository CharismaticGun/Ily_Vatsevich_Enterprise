package org.example.JD2_Maven.servlet_work;

import org.example.JD2_Maven.dto.VoteForBest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteServlet", value = "/vote")
public class VoteServlet extends HttpServlet {

    private final String HEADER_MUSICIAN = "musician";

    private final String HEADER_GENRE = "genres";

    private final VoteForBest vote = new VoteForBest();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        String [] musicians = request.getParameterMap().get(HEADER_MUSICIAN);

        if (musicians!=null) {
            for (String param : musicians) {
                if (vote.checkMusician(param)) {
                    writer.write("<p>Выбранный Вами исполнитель " + param + "</p>");
                } else {
                    writer.write("<p>Такого исполнителя нет</p>");
                }
            }
        } else {
            writer.write("<p>Введите параметры</p>" );
        }

        String [] genres = request.getParameterMap().get(HEADER_GENRE);

        if (genres!=null) {
            for (String genre : genres) {
                if (vote.checkGenre(genre)) {
                    writer.write("<p>Выбранн");
                }
            }
        }
    }
}
