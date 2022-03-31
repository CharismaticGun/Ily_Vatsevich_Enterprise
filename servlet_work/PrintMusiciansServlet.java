package org.example.Test_3.servlet_work;

import org.example.Test_3.dto.Musician;
import org.example.Test_3.dto.VoteCountMus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

@WebServlet(name = "PrintMusiciansServlet", value = "/resultMus")
public class PrintMusiciansServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.write("<h1>Исполнителя</h1>");

        VoteCountMus.getInstance().getEntryListOfMusicians().sort(new Comparator<Map.Entry<Musician, Integer>>() {
            @Override
            public int compare(Map.Entry<Musician, Integer> o1, Map.Entry<Musician, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Musician, Integer> entryListOfMusician : VoteCountMus.getInstance().getEntryListOfMusicians()) {
                writer.write("<p>" + entryListOfMusician.getKey() +" голосов - " +
                        entryListOfMusician.getValue() +  "</p>");
        }
        writer.append("<html>").
                append("<body>").
                append("<br><br>").
                append("<p>Перейдите на страницу просмотра результатов голосования</p>").
                append("<form action = resultGen>").
                append("<input type = submit value = 'Переход'/>").
                append("</form>").
                append("</body>").
                append("</html>");
        writer.close();
    }
}
