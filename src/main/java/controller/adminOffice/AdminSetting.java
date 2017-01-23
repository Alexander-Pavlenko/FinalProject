package controller.adminOffice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alexandr on 19.12.2016.
 */
@WebServlet("/AdminSetting")
public class AdminSetting extends HttpServlet {
    HttpSession session;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        req.getRequestDispatcher("/pages/AdminOffice/adminHome.jsp").forward(req,resp);

    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void updateUser(HttpServletRequest request){

    }

}
