package org.example.Test_3.servlet_work;

import org.example.Test_3.dto.Musician;
import org.example.Test_3.dto.VoteCountMus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "PrintMusiciansServlet", value = "/result")
public class PrintMusiciansServlet extends HttpServlet {

    VoteCountMus count = VoteCountMus.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        for (Map.Entry<Musician, Integer> entryListOfMusician : count.getEntryListOfMusicians()) {
            writer.write("<p>" + entryListOfMusician +"</p>");
        }




    }
}
