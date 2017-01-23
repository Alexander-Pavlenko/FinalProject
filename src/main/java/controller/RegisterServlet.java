package controller;

import dto.UserDto;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandr on 18.12.2016.
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/updated_pages/register.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = createUser(req);
        UserServiceImpl.getInstance().save(userDto);
        System.out.println("User " + userDto.getId() + "Create");

        req.getRequestDispatcher("/HomePage").forward(req,resp);
    }
    private UserDto createUser(HttpServletRequest req){
        UserDto userDto = new UserDto();
        userDto.setFirstName(req.getParameter("firstName"));
        userDto.setLogin(req.getParameter("login"));
        userDto.setClient(true);
        userDto.setE_mail(req.getParameter("e_mail"));
        userDto.setLastName(req.getParameter("lastName"));
        userDto.setPassword(req.getParameter("password"));
        userDto.setClient(true);
        return userDto;
    }
}
