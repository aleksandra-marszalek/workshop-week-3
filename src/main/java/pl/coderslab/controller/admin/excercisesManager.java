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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/excerciseManager")
public class excercisesManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Excercise> allExcercises = new ArrayList<>();
        try (Connection connection = DbUtil.getConn()) {
            allExcercises = Arrays.asList(Excercise.loadAllExcercises(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("allExcercises", allExcercises);
        getServletContext().getRequestDispatcher("/JSP/admin/excercisesManager.jsp")
                .forward(request, response);
    }
}
