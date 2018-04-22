package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Excercise;
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

@WebServlet("/deleteExcercise")
public class deleteExcercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accept = request.getParameter("accept");

        HttpSession sess = request.getSession();
        int id = (int) sess.getAttribute("id");
        Excercise newExcercise = new Excercise();


        if (accept.equals("yes")) {
            try (Connection connection = DbUtil.getConn()) {
                newExcercise = Excercise.loadExcerciseById(connection, id);
                newExcercise.delete(connection);
                response.getWriter().append("The exercise has been deleted.");
            }  catch (SQLException e) {
                response.getWriter().append("Something went wrong. the exercise has not been added");
            } catch (NullPointerException e) {
                response.getWriter().append("Something went wrong. the exercise has not been added");
            }catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            response.getWriter().append("You have not deleted the exercise.");
        }

        response.setContentType("text/html");
        response.getWriter().append("<br><a href='/excerciseManager'>Go back to exercises manager</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));


        getServletContext().getRequestDispatcher("/JSP/admin/deleteExcercise.jsp")
                .forward(request, response);
        HttpSession sess = request.getSession();
        sess.setAttribute("id", id);

    }
}
