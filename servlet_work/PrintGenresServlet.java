package org.example.Test_3.servlet_work;

import org.example.Test_3.dto.Genre;
import org.example.Test_3.dto.Musician;
import org.example.Test_3.dto.VoteCountGenre;
import org.example.Test_3.dto.VoteCountMus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

@WebServlet(name = "PrintGenresServlet", value = "/resultGen")
public class PrintGenresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write("<h1>Жанры</h1>");

        VoteCountGenre.getInstance().getEntryListOfGenres().sort(new Comparator<Map.Entry<Genre, Integer>>() {
            @Override
            public int compare(Map.Entry<Genre, Integer> o1, Map.Entry<Genre, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for (Map.Entry<Genre, Integer> entryListOfGenre : VoteCountGenre.getInstance().getEntryListOfGenres()) {
            writer.write("<p>" + entryListOfGenre.getKey() +" голосов - " +
                    entryListOfGenre.getValue() +  "</p>");
        }

        writer.append("<html>").
                append("<body>").
                append("<br><br>").
                append("<p>Перейдите на страницу просмотра результатов голосования</p>").
                append("<form action = resultMe>").
                append("<input type = submit value = 'Переход'/>").
                append("</form>").
                append("</body>").
                append("</html>");
        writer.close();
    }
    }

