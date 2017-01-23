package filter;

import dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandr on 29.12.2016.
 */
@WebFilter(filterName = "LogInFilter", urlPatterns = "/buyServlet")
public class loginInBuyTicketFilter implements Filter{
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        UserDto userDTO = (UserDto) request.getSession().getAttribute("user");
        if (userDTO != null) {
            chain.doFilter(req, resp);
        } else {
            request.getSession().setAttribute("listTiket", request.getParameter("tickets-list"));
            request.getSession().setAttribute("url", request.getRequestURI());
            request.getSession().setAttribute("message", "You must to logIn");
            response.sendRedirect(request.getContextPath() + "/pages/updated_pages/login.jsp");
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
}
