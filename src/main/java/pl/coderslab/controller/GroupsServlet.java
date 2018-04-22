package pl.coderslab.controller;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Group;

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

@WebServlet("/groups")
public class GroupsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Group> allGroups = new ArrayList<>();
        try (Connection connection = DbUtil.getConn()) {
            allGroups = Arrays.asList(Group.loadAllGroups(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("allGroups", allGroups);
        getServletContext().getRequestDispatcher("/JSP/groups.jsp")
                .forward(request, response);


    }
}
