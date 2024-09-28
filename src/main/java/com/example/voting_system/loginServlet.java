package com.example.voting_system;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet({"/LoginServlet"})
public class loginServlet extends HttpServlet {
    public loginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        int result = this.validateUser(username, password);
        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("PartyAndCandidateDetails.jsp");
        } else if (result == 2) {
            out.println("you have already voted");
        } else {
            response.setContentType("text/html");
            out.println("Invalid credentials. Please try again.");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

    }

    private int validateUser(String username, String password) {
        int valid = 0;
        Connection connection = null;

        try {
//
            connection= DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/java1");

            String query = "SELECT voted FROM login_auth WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                valid = 1;
            }
            if (resultSet.getBoolean(1)) {
                valid = 2;
            }
        } catch (SQLException var16) {
            var16.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var15) {
                var15.printStackTrace();
            }

        }

        return valid;
    }
}
