package controller;

import dto.UserDto;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandr on 18.12.2016.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    UserDto userDto;
    HttpSession session;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/updated_pages/login.jsp").forward(req,resp);
    }
    private void createUser(HttpServletRequest request){
        List<UserDto> userDtos = UserServiceImpl.getInstance().getUserByLogin(request.getParameter("login"));
        String pass = request.getParameter("password");
        for (UserDto dto : userDtos) {
            if (dto.getPassword().equals(pass))
                session.setAttribute("user", dto);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        session.setMaxInactiveInterval(1000);
        createUser(req);
        String url = "/HomePage";
        if(req.getSession().getAttribute("url")!= null)
        {
            url = (String) req.getSession().getAttribute("url");
        }
        req.getRequestDispatcher(url).forward(req,resp);
    }


}
