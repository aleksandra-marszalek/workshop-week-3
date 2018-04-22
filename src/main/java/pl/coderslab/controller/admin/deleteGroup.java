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

@WebServlet("/deleteGroup")
public class deleteGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accept = request.getParameter("accept");

        HttpSession sess = request.getSession();
        Group newGroup = (Group) (sess.getAttribute("newGroup"));
        int id = newGroup.getId();


        if (accept.equals("yes")) {
            try (Connection connection = DbUtil.getConn()) {
                newGroup = Group.loadGroupById(connection, id);
                newGroup.delete(connection);
                response.getWriter().append("The group has been deleted.");
            }catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            response.getWriter().append("You have not deleted the group.");
        }

        response.setContentType("text/html");
        response.getWriter().append("<br><a href='/groupsManager'>Go back to groups manager</a>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        Group newGroup = new Group();


        List<User> allUsers = new ArrayList<>();
        try (Connection connection = DbUtil.getConn()) {
            allUsers = Arrays.asList(User.loadAllbyGroupId(connection, id));
            newGroup = Group.loadGroupById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("allUsers", allUsers);
        request.setAttribute("newGroup", newGroup);
        getServletContext().getRequestDispatcher("/JSP/admin/deleteGroup.jsp")
                .forward(request, response);
        HttpSession sess = request.getSession();
        sess.setAttribute("newGroup", newGroup);


    }
}
