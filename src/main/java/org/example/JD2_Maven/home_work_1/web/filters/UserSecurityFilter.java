package org.example.JD2_Maven.home_work_1.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/user/*","/api/message"})
public class UserSecurityFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res = ((HttpServletResponse) response);
        HttpServletRequest req = ((HttpServletRequest) request);
        String path = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session!=null)&&(session.getAttribute("user")!=null)) {
            chain.doFilter(request,response);
        } else {
            res.sendRedirect(path+"/ui/signIn");
        }
    }
}
