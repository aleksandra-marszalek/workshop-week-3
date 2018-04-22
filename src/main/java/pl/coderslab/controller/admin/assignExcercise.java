package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/assignExcercise")
public class assignExcercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();
        int exId = (int) sess.getAttribute("exId");
        int userId = Integer.parseInt(request.getParameter("userId"));


        try (Connection connection = DbUtil.getConn()) {
            Solution solutionNew = new Solution();
            LocalDateTime datetime = LocalDateTime.now();
            String dateTimeNow = datetime.toString();
            solutionNew.setCreated(dateTimeNow);
            solutionNew.setUsers_id(userId);
            solutionNew.setExcercise_id(exId);
            solutionNew.saveToDB(connection);
            response.getWriter().append("The exercise has been assigned successfully.");
        }  catch (SQLException e) {
            response.getWriter().append("Something went wrong. the exercise has not been assigned");
        } catch (NullPointerException e) {
            response.getWriter().append("Something went wrong. the exercise has not been assigned");
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().append("<br><a href='/excerciseManager'>Go back to exercises manager</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int exId = Integer.parseInt(request.getParameter("id"));


        getServletContext().getRequestDispatcher("/JSP/admin/assignExcercise.jsp")
                .forward(request, response);
        HttpSession sess = request.getSession();
        sess.setAttribute("exId", exId);
    }
}
