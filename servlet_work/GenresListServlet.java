package org.example.JD2_Maven.servlet_work;

import org.example.JD2_Maven.dto.Genre;
import org.example.JD2_Maven.dto.ListOfGenres;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenresListServlet", value = "/genres")
public class GenresListServlet extends HttpServlet {

    private final ListOfGenres genres = ListOfGenres.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write("<h1>Жанры</h1>");

        for (Genre genre : genres.getGenres()) {
            writer.write("<p>" + genre +"</p>");
        }
        writer.append("<html>").
                append("<body>").
                append("<br><br>").
                append("<p>Перейдите на страницу голосования </p>").
                append("<form action = vote>").
                append("<input type = submit value = 'Переход'/>").
                append("</form>").
                append("</body>").
                append("</html>");
        writer.close();
    }
}
