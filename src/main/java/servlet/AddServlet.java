package servlet;

import AcessDB.ServiceClient;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private ServiceClient serv;

    @Override
    public void init() throws ServletException {
        super.init();
        serv = new ServiceClient();
        serv.createTable();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String birthday = req.getParameter("date");
        User newUser = new User(name, surname, password, birthday);
        serv.addUser(newUser);
        res.sendRedirect("http://localhost:8080");
    }
}














