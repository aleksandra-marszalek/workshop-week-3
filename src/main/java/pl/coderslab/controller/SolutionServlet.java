package pl.coderslab.controller;

import com.mysql.jdbc.EscapeTokenizer;
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

@WebServlet("/solution")
public class SolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Solution newSolution = new Solution();

        try (Connection connection = DbUtil.getConn()) {
            newSolution = Solution.loadSolutionById(connection, id);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("solution", newSolution);

        getServletContext().getRequestDispatcher("/JSP/solution.jsp")
                .forward(request, response);


    }
}
