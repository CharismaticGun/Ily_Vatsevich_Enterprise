package org.example.JD2_Maven.home_work_1.web.servlets.api;

import org.example.JD2_Maven.home_work_1.dto.Roles;
import org.example.JD2_Maven.home_work_1.dto.User;
import org.example.JD2_Maven.home_work_1.web.service.StatisticStorage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAdminStatistic", value = "/api/admin/statistic")
public class ServletAdminStatistic extends HttpServlet {

    private final StatisticStorage ss = StatisticStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();

        User user = ((User) request.getSession().getAttribute("user"));

        if (user!=null&&user.getRole().equals(Roles.ADMIN.name())) {
            writer.write(ss.getCountActiveSessions() + "</br>" + ss.getCountSendMessages() );
        } else {
            throw new IllegalAccessError("У вас не доступа к данному функционалу");
        }
    }
}
