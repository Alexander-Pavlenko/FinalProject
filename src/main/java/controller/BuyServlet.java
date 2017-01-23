package controller;

import dto.HallDto;
import dto.SessionDto;
import dto.TicketDto;
import dto.UserDto;
import service.impl.HallServiceImpl;
import service.impl.SessionServiceImpl;
import service.impl.TicketServiceImpl;

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
 * Created by Alexandr on 18.12.2016.
 */
@WebServlet("/buyServlet")
public class BuyServlet extends HttpServlet {
    private HttpSession session;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        if(req.getParameter("tickets-list")==null && req.getSession().getAttribute("listTiket")==null){
            req.getRequestDispatcher("/pages/updated_pages/buyTicket.jsp").forward(req,resp);
        }
        List<TicketDto> ticketDtos = new ArrayList<>();
        String hallId = (String) session.getAttribute("hallId");
        HallDto hallDto = HallServiceImpl.getInstance().getById(Integer.parseInt(hallId));
        String sessionId = (String) session.getAttribute("idSession");
        SessionDto sessionDto = SessionServiceImpl.getInstance().getById(Integer.parseInt(sessionId));


        String ticket_list = null;
        if(req.getParameter("tickets-list") != null){
            ticket_list = req.getParameter("tickets-list");
        }
        else {
            ticket_list = (String) req.getSession().getAttribute("listTiket");
        }
        UserDto userDto = ((UserDto)session.getAttribute("user"));

        ticketDtos = TicketServiceImpl.getInstance().returnTickets(ticket_list, hallDto, userDto, sessionDto);

        if(ticketDtos == null){
            resp.sendRedirect("/sessionServlet?id="+ sessionDto.getHallDto().getId()+"&message=Not enough money!");

        }
        else {
            req.setAttribute("list", ticketDtos);
            req.getRequestDispatcher("/pages/updated_pages/Welcame.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("tickets-list")!=null){
            doPost(req,resp);
        }
        req.getRequestDispatcher("/pages/updated_pages/buyTicket.jsp").forward(req,resp);

    }
}
