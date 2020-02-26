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

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private ServiceClient serv;

    @Override
    public void init() throws ServletException {
        super.init();
        serv = new ServiceClient();
        serv.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<User> user = serv.getAllUser();
        req.setAttribute("users", user);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req, res);
    }
}

















