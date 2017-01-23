package controller.adminOffice;

import dto.UserDto;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandr on 21.12.2016.
 */
@WebServlet("/AdminUsers")
public class AdminUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("viewUser")!= null){
            getUserList(request,response);
        }
        if(request.getParameter("delete")!=null){
            int id = Integer.parseInt(request.getParameter("delete"));
            UserServiceImpl.getInstance().delete(id);
        }
        if(request.getParameter("UpdateUser")!= null){
            UserDto userDto = createUser(request);
            userDto.setId(Integer.parseInt(request.getParameter("id")));
            UserServiceImpl.getInstance().update(userDto);
        }
        if(request.getParameter("edit") != null){
            String s = request.getParameter("edit");
            int i = Integer.parseInt(s);
            getUserById(request,i);
            request.setAttribute("display", "block");
        }
        else {
            request.setAttribute("index",request.getParameter("name"));
            request.setAttribute("display", "none");
        }



        request.getRequestDispatcher("/pages/AdminOffice/adminUserSetting.jsp").forward(request,response);

    }

    private UserDto createUser(HttpServletRequest request){
        UserDto userDto = new UserDto();
        userDto.setLogin(request.getParameter("login"));
        userDto.setFirstName(request.getParameter("firstName"));
        userDto.setLastName(request.getParameter("lastName"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setE_mail(request.getParameter("e_mail"));
        userDto.setClient(Boolean.valueOf(request.getParameter("isClient")));
        return userDto;

    }
    private void getUserList(HttpServletRequest request, HttpServletResponse response){
        List<UserDto> userDtos = UserServiceImpl.getInstance().getAll();
        request.setAttribute("userList", userDtos);

    }
    public void getUserById(HttpServletRequest request, int id){
        UserDto userDto = UserServiceImpl.getInstance().getById(id);
        request.setAttribute("user", userDto);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/AdminOffice/adminUserSetting.jsp").forward(request,response);
    }
}
