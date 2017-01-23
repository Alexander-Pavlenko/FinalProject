package controller.adminOffice;

import dto.SessionDto;
import service.impl.FilmServiceImpl;
import service.impl.HallServiceImpl;
import service.impl.SessionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Alexandr on 28.12.2016.
 */
@WebServlet("/AdminSession")
public class AdminSessionSetting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/AdminOffice/adminSessionSetting.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         if(req.getParameter("viewSessions")!= null){
            getList(req);
        }
        if(req.getParameter("delete")!=null){
            int id = Integer.parseInt(req.getParameter("delete"));
            SessionServiceImpl.getInstance().delete(id);
        }
        if(req.getParameter("AddSession")!=null){
            createSessionDto(req,resp);
        }
        if(req.getParameter("UpdateSession")!= null){
            SessionDto sessionDto = createFilm(req);
            sessionDto.setId(Integer.parseInt(req.getParameter("id")));
            SessionServiceImpl.getInstance().update(sessionDto);
        }
        if(req.getParameter("edit") != null){
            String s = req.getParameter("edit");
            int i = Integer.parseInt(s);
            getSessionById(req,i);
            req.setAttribute("display", "block");
        }
        else {
            req.setAttribute("index",req.getParameter("name"));
            req.setAttribute("display", "none");
        }
        req.getRequestDispatcher("/pages/AdminOffice/adminSessionSetting.jsp").forward(req,resp);

    }
    private void getList(HttpServletRequest req){
        List<SessionDto> list = SessionServiceImpl.getInstance().getAll();
        req.setAttribute("listSession", list);
    }
    public void createSessionDto(HttpServletRequest req, HttpServletResponse resp){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setDate(LocalDateTime.now());
        sessionDto.setFilmDto(FilmServiceImpl.getInstance().getById(Integer.parseInt(req.getParameter("idFilm"))));
        sessionDto.setHallDto(HallServiceImpl.getInstance().getById(Integer.parseInt(req.getParameter("idHall"))));

        sessionDto = SessionServiceImpl.getInstance().save(sessionDto);

        System.out.println("Session"+ sessionDto.getId() +" create.");

        try {
            req.getRequestDispatcher("/pages/AdminOffice/adminSessionSetting.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private SessionDto createFilm(HttpServletRequest request){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setFilmDto(FilmServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("idFilm"))));
        sessionDto.setHallDto(HallServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("idHall"))));
        sessionDto.setDate(LocalDateTime.now());
        return sessionDto;

    }
    public void getSessionById(HttpServletRequest request, int id){
        SessionDto sessionDto = SessionServiceImpl.getInstance().getById(id);
        request.setAttribute("session", sessionDto);
    }

}
