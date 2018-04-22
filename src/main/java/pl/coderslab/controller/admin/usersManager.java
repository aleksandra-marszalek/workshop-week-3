package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/usersManager")
public class usersManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> allUsers = new ArrayList<>();
        try (Connection connection = DbUtil.getConn()) {
            allUsers = Arrays.asList(User.loadAllUsers(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("allUsers", allUsers);
        getServletContext().getRequestDispatcher("/JSP/admin/usersManager.jsp")
                .forward(request, response);
    }
}
