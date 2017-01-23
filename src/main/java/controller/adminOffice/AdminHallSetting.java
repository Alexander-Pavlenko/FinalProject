package controller.adminOffice;

import dto.HallDto;
import service.impl.HallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandr on 28.12.2016.
 */
@WebServlet("/AdminHall")
public class AdminHallSetting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/AdminOffice/adminHallSetting.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("viewHalls")!= null){
            getList(req);
        }
        if(req.getParameter("delete")!=null){
            int id = Integer.parseInt(req.getParameter("delete"));
            HallServiceImpl.getInstance().delete(id);
        }
        if(req.getParameter("AddHall")!=null){
            createHallDto(req,resp);
        }

        req.getRequestDispatcher("/pages/AdminOffice/adminHallSetting.jsp").forward(req,resp);
    }
    private void getList(HttpServletRequest req){
        List<HallDto> list = HallServiceImpl.getInstance().getAll();
        req.setAttribute("listHalls", list);
    }
    public void createHallDto(HttpServletRequest req, HttpServletResponse resp){
        int columns = Integer.parseInt(req.getParameter("columns"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        double price = Double.parseDouble(req.getParameter("price"));

        HallDto hallDto = new HallDto(columns, rows, price);
        hallDto.setName(req.getParameter("title"));
        hallDto = HallServiceImpl.getInstance().save(hallDto);

        System.out.println("Hall"+ hallDto.getId() +" create.");
        try {
            req.getRequestDispatcher("/pages/AdminOffice/adminHallSetting.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
