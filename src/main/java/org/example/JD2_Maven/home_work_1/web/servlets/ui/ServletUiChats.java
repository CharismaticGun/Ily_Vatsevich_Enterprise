package org.example.JD2_Maven.home_work_1.web.servlets.ui;

import org.example.JD2_Maven.home_work_1.dto.Message;
import org.example.JD2_Maven.home_work_1.web.service.MessageControl;
import org.example.JD2_Maven.home_work_1.web.service.MessageStorage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUiChats", value = "/ui/user/chats")
public class ServletUiChats extends HttpServlet {

    private final MessageControl mc = new MessageControl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ServletContext context = getServletContext();

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/jsp/ui/user/chats.jsp");

        List<Message> messages = mc.getMessage(request);

        request.setAttribute("messages",messages);

        requestDispatcher.forward(request,response);

    }
}
