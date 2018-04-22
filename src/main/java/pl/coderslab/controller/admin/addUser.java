package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/addUser")
public class addUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection connection = DbUtil.getConn()) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int id = Integer.parseInt(request.getParameter("userId"));
            User userNew = new User();
            userNew.setUsername(username);
            userNew.setEmail(email);
            userNew.setPassword(password);
            userNew.setUser_group_id(id);
            userNew.saveToDB(connection);

            response.getWriter().append("User has been added successfully.");
        }  catch (SQLException e) {
            response.getWriter().append("Something went wrong. the user has not been added");
        } catch (NullPointerException e) {
            response.getWriter().append("Something went wrong. the user has not been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append("<br><a href='/usersManager'>Go back to user manager</a>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/JSP/admin/addUser.jsp")
                .forward(request, response);

    }
}
