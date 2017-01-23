package controller;

import dto.TicketDto;
import dto.UserDto;
import service.impl.TicketServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 19.12.2016.
 */
@WebServlet("/PersonalOffice")
public class PersonalOfficeServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        if(req.getParameter("Add")!=null){
            if(!req.getParameter("moneyAdd").isEmpty())
            {
                double money = Double.parseDouble(req.getParameter("moneyAdd"));
                UserDto userDto = (UserDto) session.getAttribute("user");
                userDto.setMoney(userDto.getMoney() + money);
                UserServiceImpl.getInstance().update(userDto);
            }
        }
        if(req.getParameter("UpdateUser")!= null){
            UserDto userDto = createUser(req);
            userDto.setId(Integer.parseInt(req.getParameter("id")));
            UserServiceImpl.getInstance().update(userDto);
        }
        if(req.getParameter("show")!=null){
            TicketDto ticketDto = TicketServiceImpl.getInstance().getById(Integer.parseInt(req.getParameter("show")));
            List<TicketDto> ticketDtoList = new ArrayList<>();
            ticketDtoList.add(ticketDto);
            req.setAttribute("list", ticketDtoList);
            req.getRequestDispatcher("/pages/updated_pages/Welcame.jsp").forward(req,resp);
            return;

        }
        if(req.getParameter("viewHistory")!= null){
            UserDto userDto = (UserDto) session.getAttribute("user");
            List<TicketDto> ticketDtoList = TicketServiceImpl.getInstance().getListByIdUser(userDto.getId());
            req.setAttribute("ticketDtoList", ticketDtoList);

        }
        if(req.getParameter("edit") != null){
            String s = req.getParameter("edit");
            req.setAttribute("display", "block");
        }
        else {
               req.setAttribute("display", "none");
        }
        req.getRequestDispatcher("/pages/updated_pages/personalOffice.jsp").forward(req,resp);
    }
    private UserDto createUser(HttpServletRequest request){
        UserDto userDto =((UserDto)session.getAttribute("user"));
        userDto.setLogin(request.getParameter("login"));
        userDto.setFirstName(request.getParameter("firstName"));
        userDto.setLastName(request.getParameter("lastName"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setE_mail(request.getParameter("e_mail"));
        userDto.setClient(Boolean.valueOf(request.getParameter("isClient")));
        return userDto;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        UserDto userDtom = (UserDto)session.getAttribute("user");
        UserDto userDto = UserServiceImpl.getInstance().getById(userDtom.getId());
        session.setAttribute("user",userDto);
        req.getRequestDispatcher("/pages/updated_pages/personalOffice.jsp").forward(req,resp);
    }
}
