package org.example.JD2_Maven.home_work_1.web.servlets.ui;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUiSignIn", value = "/ui/signIn")
public class ServletUiSignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ServletContext context = getServletContext();

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/jsp/ui/signIn.jsp");

        requestDispatcher.forward(request,response);

    }
}
