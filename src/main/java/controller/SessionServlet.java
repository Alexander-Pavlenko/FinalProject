package controller;

import dto.HallDto;
import model.Place;
import service.impl.HallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexandr on 11.12.2016.
 */
@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String s = req.getParameter("id");
        String message = null;
        if(req.getParameter("message") != null){
            message = req.getParameter("message");
        }

        HallDto hallDto = HallServiceImpl.getInstance().getById(Integer.parseInt(s));
        Place[][] places = hallDto.getPlaces();
        session.setAttribute("hallId", s);
        session.setAttribute("idSession", req.getParameter("idSession"));

        req.setAttribute("message", message);
        req.setAttribute("column", hallDto.getCountColumn());
        req.setAttribute("row", hallDto.getCountRow());
        req.setAttribute("hall", places);

        req.getRequestDispatcher("/pages/updated_pages/buyTicket.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
