package controller;



import dto.FilmDto;
import service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
private int index = 0;
HttpSession session;
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
                if(req.getParameter("next")!=null||
                req.getParameter("prev")!=null){

            change(req);
        }
        List<FilmDto> movies = getList();
        System.out.println(movies.size());
        req.setAttribute("movieList", movies);
        req.setAttribute("listBest", movies);
        req.getRequestDispatcher("/pages/updated_pages/main.jsp").forward(req,resp);
            ////WEB-INF/pages/HomePage.jsp
        ///updated_pages/main.jsp
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
    public void change(HttpServletRequest req){
        int size = ((Integer) session.getAttribute("maxSize"));
        if(req.getParameter("next")!= null & index + 3 < size)
            index++;
        if (req.getParameter("prev")!= null & index > 0)
            index--;
    }
    private List<FilmDto> getList(){
        List<FilmDto> list = null;
            list = FilmServiceImpl.getInstance().getAll();
        session.setAttribute("index", index);
        session.setAttribute("maxSize", list.size());
        return list.subList(index, index+3);
    }
}
