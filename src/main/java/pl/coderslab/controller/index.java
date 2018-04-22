package pl.coderslab.controller;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "index")
public class index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Solution newSolution = new Solution();

        int numberSolutions = Integer.parseInt(getInitParameter("number-solutions"));

        Solution[] allSolutions = new Solution[numberSolutions];
        try (Connection connection = DbUtil.getConn()) {
            allSolutions = Solution.loadAllSolutions(connection, numberSolutions);

        } catch (SQLException e) {
            System.out.println("SQL ERROR: ");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("allSolutions", allSolutions);

        getServletContext().getRequestDispatcher("/JSP/index.jsp")
                .forward(request, response);



    }
}
