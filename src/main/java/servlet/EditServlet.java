package servlet;

import AccessDB.ServiceClient;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private ServiceClient serv;

    @Override
    public void init() throws ServletException {
        super.init();
        serv = new ServiceClient();
        serv.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        User newUser = new User();
//        newUser.setId(Long.parseLong(req.getParameter("id")));
//        newUser.setName(req.getParameter("name"));
//        newUser.setSurname(req.getParameter("surname"));
//        newUser.setPassword(req.getParameter("password"));
//        newUser.setBirthday(req.getParameter("birthday"));
//        serv.updateUser(newUser);
//        res.sendRedirect("http://localhost:8080");
        List<User> user = serv.getAllUser();
        req.setAttribute("users", user);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(req, res);
    }
}



















