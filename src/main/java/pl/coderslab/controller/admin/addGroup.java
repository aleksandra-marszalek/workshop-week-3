package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addGroup")
public class addGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String groupName = request.getParameter("groupName");


        try (Connection connection = DbUtil.getConn()) {
            Group newGroup = new Group();
            newGroup.setName(groupName);
            newGroup.saveToDB(connection);
            response.getWriter().append("Group added successfully.");
        }  catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error! Please try again later! "+ e.getMessage());
        }

        response.getWriter().append("<br><a href='/groupsManager'>Go back to groups manager</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/JSP/admin/addGroup.jsp")
                .forward(request, response);
    }
}
