package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/addExcercise")
public class addExcercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String excerciseTitle = request.getParameter("title");
        String excerciseDesc = request.getParameter("description");


        try (Connection connection = DbUtil.getConn()) {
            Excercise newExcercise = new Excercise();
            newExcercise.setTitle(excerciseTitle);
            newExcercise.setDescription(excerciseDesc);
            newExcercise.saveToDB(connection);
            response.getWriter().append("Excercise added successfully.");
        }  catch (SQLException e) {
            response.getWriter().append("Something went wrong. the exercise has not been added");
        } catch (NullPointerException e) {
            response.getWriter().append("Something went wrong. the exercise has not been added");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append("<br><a href='/excerciseManager'>Go back to exercise manager</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/JSP/admin/addExcercise.jsp")
                .forward(request, response);
    }
}
