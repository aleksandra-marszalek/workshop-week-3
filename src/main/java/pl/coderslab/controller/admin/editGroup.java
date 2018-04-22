package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/editGroup")
public class editGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();
        int idGroup = (int) sess.getAttribute("idGroup");
        String groupName = request.getParameter("groupName");


        try (Connection connection = DbUtil.getConn()) {
            Group groupToEdit = Group.loadGroupById(connection, idGroup);
            groupToEdit.setName(groupName);
            groupToEdit.saveToDB(connection);
            response.getWriter().append("Group edited successfully.");
        }  catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error! Please try again later! "+ e.getMessage());
        }

        response.getWriter().append("<br><a href='/groupsManager'>Go back to groups manager</a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sess = request.getSession();
        sess.setAttribute("idGroup", id);

        getServletContext().getRequestDispatcher("/JSP/admin/editGroup.jsp")
                .forward(request, response);


    }
}
