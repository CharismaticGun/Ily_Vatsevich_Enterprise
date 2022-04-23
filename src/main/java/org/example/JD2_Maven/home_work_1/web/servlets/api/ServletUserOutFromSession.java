package org.example.JD2_Maven.home_work_1.web.servlets.api;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUserOutFromSession", urlPatterns = "/api/logout")
public class ServletUserOutFromSession extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String path = request.getContextPath();

        HttpSession session = request.getSession();

        if (session!=null) {
            session.invalidate();
            response.sendRedirect(path+"/ui");
        }

    }
}
