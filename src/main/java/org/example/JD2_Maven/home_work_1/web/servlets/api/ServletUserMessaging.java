package org.example.JD2_Maven.home_work_1.web.servlets.api;

import org.example.JD2_Maven.home_work_1.dto.Message;
import org.example.JD2_Maven.home_work_1.web.service.MessageControl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletUserMessaging", value = "/api/message")
public class ServletUserMessaging extends HttpServlet {

    private final MessageControl mc = new MessageControl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        List<Message> messages = mc.getMessage(request);

        PrintWriter writer = response.getWriter();

        for (Message message : messages) {
            writer.write(message.getTimeOfSend() + " "
                    + message.getFromWho() + " "
                    + message.getTextOfMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String path = request.getContextPath();

        String login = request.getParameter("login");

        String messageText = request.getParameter("messageText");

        boolean b = mc.sendMessage(request, login, messageText);

        response.setContentType("text/html;charset=UTF-8");

        if (b) {
            response.sendRedirect(path + "/ui");
        } else {
            response.sendRedirect(path+"/ui/user/message");
        }
    }
}
