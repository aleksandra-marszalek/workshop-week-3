package pl.coderslab.controller.admin;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/editExcercise")
public class editExercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sess = request.getSession();
        int idEx = (int) sess.getAttribute("idEx");
        String titleEx = request.getParameter("title");
        String descEx = request.getParameter("description");


        try (Connection connection = DbUtil.getConn()) {
            Excercise excerciseToEdit = Excercise.loadExcerciseById(connection, idEx);
            excerciseToEdit.setTitle(titleEx);
            excerciseToEdit.setDescription(descEx);
            excerciseToEdit.saveToDB(connection);
            response.getWriter().append("Exercise edited successfully.");
        }  catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error! Please try again later! "+ e.getMessage());
        }

        response.getWriter().append("<br><a href='/excerciseManager'>Go back to exercise manager</a>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sess = request.getSession();
        sess.setAttribute("idEx", id);

        getServletContext().getRequestDispatcher("/JSP/admin/editExcercise.jsp")
                .forward(request, response);
    }
}
