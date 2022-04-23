package org.example.JD2_Maven.home_work_1.web.servlets.api;

import org.example.JD2_Maven.home_work_1.dto.User;
import org.example.JD2_Maven.home_work_1.web.service.UserControl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUserLogin", value = "/api/login")
public class ServletUserLogin extends HttpServlet {

    private final UserControl us = new UserControl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String path = request.getContextPath();

        String login = request.getParameter("login");

        String password = request.getParameter("password");

        User user = us.userLogIn(login, password);

        request.getSession().setAttribute("user",user);

        response.sendRedirect(path+"/ui");

    }
}
