package com.example.voting_system;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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

@WebServlet({"/VoteServlet"})
public class VoteServlet extends HttpServlet {
    public VoteServlet() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            HttpSession var10001 = req.getSession();
            out.println("<h2>Thank you for voting</h2><h2>" + String.valueOf(var10001.getAttribute("username")) + "</h2");

            Connection con= DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/java1");

            String query = "UPDATE login_auth SET voted='1' WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, (String)req.getSession().getAttribute("username"));
            ps.setString(2, (String)req.getSession().getAttribute("password"));
            int rs = ps.executeUpdate();
            if (rs > 0) {
                out.println("Voted successfully!");
            } else {
                out.println("Vote failed.");
            }

            out.println("<p><a href="+"logout.jsp"+">Logout</a></p>");

        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }
}

