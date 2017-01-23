package controller;


import dto.FilmDto;
import dto.SessionDto;
import service.impl.FilmServiceImpl;
import service.impl.SessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/movie")
public class MovieServlet extends HttpServlet {
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        String s = req.getParameter("id");

        FilmDto filmDto = FilmServiceImpl.getInstance().getById(Integer.parseInt(s));
        List<SessionDto> sessionDtos = SessionServiceImpl.getInstance().getSessionByIdFilm(Integer.parseInt(s));

        req.setAttribute("movie", filmDto);
        req.setAttribute("sessions",sessionDtos);
        for (SessionDto sessionDto : sessionDtos) {
            System.out.println(sessionDto);
        }

        req.getRequestDispatcher("/pages/updated_pages/single.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
