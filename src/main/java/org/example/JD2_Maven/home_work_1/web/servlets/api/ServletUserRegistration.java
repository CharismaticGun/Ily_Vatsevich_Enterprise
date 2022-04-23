package org.example.JD2_Maven.home_work_1.web.servlets.api;

import org.example.JD2_Maven.home_work_1.web.service.UserStorage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUserRegistration", value = "/api/user")
public class ServletUserRegistration extends HttpServlet {

    private final UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        String path = request.getContextPath();

        String login = request.getParameter("login");

        String password = request.getParameter("password");

        String fullName = request.getParameter("fullName");

        String dateOfBirth = request.getParameter("dateOfBirth");

        boolean checkRegistration = false;
        try {
            checkRegistration = storage.userRegistration(login, password, fullName, dateOfBirth);
        } catch (IllegalArgumentException e) {
            response.sendRedirect(path + "/ui/signUp");
            return;
        }

        if (checkRegistration) {
           response.sendRedirect(path + "/ui/signIn");
        } else {
            response.sendRedirect(path + "/ui");
        }
    }
}
