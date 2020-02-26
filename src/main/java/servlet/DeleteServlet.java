package servlet;

import AccessDB.ServiceClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private ServiceClient serv;

    @Override
    public void init() throws ServletException {
        super.init();
        serv = new ServiceClient();
        serv.createTable();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        serv.deletUser(id);
        res.sendRedirect("http://localhost:8080");
    }
}
















