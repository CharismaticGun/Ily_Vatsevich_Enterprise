package org.example.Test_3.servlet_work;

import org.example.Test_3.dto.InformationAboutMe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "PrintMeInfoServlet",urlPatterns = "/resultMe")
public class PrintMeInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<h1>Информация обо мне</h1>");
        writer.write("<p>" + InformationAboutMe.getInstance().getDescription() +"</p>");
        writer.write("<h1>Время записи</h1>");
        writer.write("<p>" + InformationAboutMe.getInstance().getDateTime() + "</p>");
    }
}
