package org.example.JD2_Maven.servlet_work;

import org.example.JD2_Maven.dto.ListOfMusicians;
import org.example.JD2_Maven.dto.Musician;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "MusicianListServlet",urlPatterns = "/musicians")
public class MusicianListServlet extends HttpServlet {

    private final ListOfMusicians musicians = ListOfMusicians.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<h1>Исполнителя</h1>");

        for (Musician musician : musicians.getMusicians()) {
            writer.write("<p>" + musician + "</p>");
        }
        writer.append("<html>").
                append("<body>").
                append("<br><br>").
                append("<p>Перейдите на страницу просмотра жанров</p>").
                append("<form action = genres>").
                append("<input type = submit value = 'Переход'/>").
                append("</form>").
                append("</body>").
                append("</html>");
        writer.close();
    }

}

