package controller.adminOffice;

import dto.DescriptionDto;
import dto.FilmDto;
import model.FormatFilm;
import service.impl.DescriptionServiceImpl;
import service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Alexandr on 27.12.2016.
 */
@WebServlet("/AdminFilmSetting")
public class AdminFilmSetting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/AdminOffice/adminFilmSetting.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("viewFilms")!= null){
            getList(req);
        }
        if(req.getParameter("delete")!=null){
            int id = Integer.parseInt(req.getParameter("delete"));
            FilmServiceImpl.getInstance().delete(id);
        }
        if(req.getParameter("AddFilm")!=null){
            createFilmDto(req,resp);
        }
        if(req.getParameter("UpdateUser")!= null){
            FilmDto filmDto = createFilm(req);
            filmDto.setId(Integer.parseInt(req.getParameter("id")));
            FilmServiceImpl.getInstance().update(filmDto);
        }
        if(req.getParameter("edit") != null){
            String s = req.getParameter("edit");
            int i = Integer.parseInt(s);
            getFilmById(req,i);
            req.setAttribute("display", "block");
        }
        else {
            req.setAttribute("index",req.getParameter("name"));
            req.setAttribute("display", "none");
        }
        req.getRequestDispatcher("/pages/AdminOffice/adminFilmSetting.jsp").forward(req,resp);
    }
    private void getList(HttpServletRequest req){
        List<FilmDto> list = FilmServiceImpl.getInstance().getAll();
        req.setAttribute("listFilm", list);
    }
    public void getFilmById(HttpServletRequest request, int id){
        FilmDto filmDto = FilmServiceImpl.getInstance().getById(id);
        request.setAttribute("film", filmDto);
    }
    private FilmDto createFilm(HttpServletRequest request){
        FilmDto filmDto = new FilmDto();
        filmDto.setName(request.getParameter("title"));
        DescriptionDto descriptionDto = DescriptionServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("idDes")));
        descriptionDto.setFormatFilm(FormatFilm.getFormatFilm(request.getParameter("formatFilm")));
        descriptionDto.setDuration(Integer.parseInt(request.getParameter("duration")));
        descriptionDto.setPicture(request.getParameter("picture"));
        descriptionDto.setMiniDescription(request.getParameter("description"));
        descriptionDto.setId(Integer.parseInt(request.getParameter("idDes")));

        filmDto.setDescription(descriptionDto);
        DescriptionServiceImpl.getInstance().update(descriptionDto);
        return filmDto;

    }

    public void createFilmDto(HttpServletRequest req, HttpServletResponse resp){
        DescriptionDto descriptionDto = new DescriptionDto();
        descriptionDto.setPicture(req.getParameter("picture"));
        descriptionDto.setDuration(Integer.parseInt(req.getParameter("duration")));
        descriptionDto.setFormatFilm(FormatFilm.getFormatFilm(req.getParameter("formatFilm")));
        descriptionDto.setRelease(LocalDateTime.now());
        FilmDto filmDto = new FilmDto();
        filmDto.setName(req.getParameter("title"));
        descriptionDto = DescriptionServiceImpl.getInstance().save(descriptionDto);
        filmDto.setDescription(descriptionDto);
        FilmServiceImpl.getInstance().save(filmDto);

        System.out.println("Description"+ descriptionDto.getId() +" create.");
        System.out.println("Film"+ filmDto.getId() +" create.");

        try {
            req.getRequestDispatcher("/pages/AdminOffice/adminFilmSetting.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
