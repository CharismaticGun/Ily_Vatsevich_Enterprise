package org.example.JD2_Maven.home_work_1.web.servlets.ui;

import org.example.JD2_Maven.home_work_1.dto.Roles;
import org.example.JD2_Maven.home_work_1.dto.User;
import org.example.JD2_Maven.home_work_1.web.service.StatisticStorage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUiAdmin", value = "/ui/admin/statistic")
public class ServletUiAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        User user = ((User) request.getSession().getAttribute("user"));

        if (null!=user&&user.getRole().equals(Roles.ADMIN.name())) {
            request.setAttribute("activeSessions", StatisticStorage.getInstance().getCountActiveSessions());
            request.setAttribute("sentMessages",StatisticStorage.getInstance().getCountSendMessages());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/ui/admin/statistic.jsp");
            requestDispatcher.forward(request,response);
        } else {
            throw new IllegalAccessError("У вас нет доступа к данному функционалу");
        }
    }
}
