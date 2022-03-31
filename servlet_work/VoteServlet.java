package org.example.Test_3.servlet_work;

import org.example.Test_3.dto.VoteForBest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteServlet", value = "/vote")
public class VoteServlet extends HttpServlet {

    private final String HEADER_MUSICIAN = "musician";

    private final String HEADER_GENRE = "genres";

    private final String HEADER_ABOUT_ME = "me";

    private final VoteForBest vote = new VoteForBest();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        String[] musicians = request.getParameterMap().get(HEADER_MUSICIAN);

        String[] genres = request.getParameterMap().get(HEADER_GENRE);

        String me = request.getParameter(HEADER_ABOUT_ME);

        if (musicians == null || genres == null || me == null) {
            writer.write("Введите данные согласно требованиям: исполнитель - 1; жанры - 3-10; информация о себе");
            writer.close();
        } else {

            if (musicians.length == 1 && (genres.length >= 3 && genres.length <= 10)) {

                for (String param : musicians) {
                    if (vote.checkMusician(param)) {
                        writer.write("<p>Выбранный Вами исполнитель: " + param + "</p>");
                    } else {
                        writer.write("<p>Такого исполнителя нет: " + param + "</p>");
                    }
                }

                for (String genre : genres) {
                    if (vote.checkGenre(genre)) {
                        writer.write("<p>Выбранные жанры: " + genre + "</p>");
                    }
                }

                String description = vote.putInMe(me);
                writer.write("<p>Информация о Вас: " + description + "</p>");

                if (vote.checkAll()) {
                    writer.append("<html>").
                            append("<body>").
                            append("<br><br>").
                            append("<p>Перейдите на страницу просмотра результатов голосования</p>").
                            append("<form action = resultMus>").
                            append("<input type = submit value = 'Переход'/>").
                            append("</form>").
                            append("</body>").
                            append("</html>");
                    writer.close();
                }
            } else {
                writer.write("Введите данные согласно требованиям: исполнитель - 1; жанры - 3-10; информация о себе");
            }
        }
    }
}