package org.example.JD2_Maven.home_work_1.web.filters;

import org.example.JD2_Maven.home_work_1.dto.Roles;
import org.example.JD2_Maven.home_work_1.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/ui/admin/*","/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpServletResponse resp = ((HttpServletResponse) response);
        String path  = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session!=null) && (session.getAttribute("user")!=null)) {
            User user = ((User) session.getAttribute("user"));
            if (user.getRole().equals(Roles.ADMIN.name())) {
                chain.doFilter(request,response);
            }
        }else {
            resp.sendRedirect(path + "/ui");
        }
    }
}
