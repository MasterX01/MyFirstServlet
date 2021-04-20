package com.firstservletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	description = "Login Servlet Testing",
	urlPatterns = { "/LoginServlet" },
	initParams = {
			@WebInitParam(name = "user", value = "Akash"),
			@WebInitParam(name = "password", value = "akash14@gmail")
	}
)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		
		String userTest = getServletConfig().getInitParameter("user");
		String pwdTest = getServletConfig().getInitParameter("password");
		if(userTest.equals(userTest) && pwdTest.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either username or password is incorrect.</font>");
			rd.include(request, response);
		}
	}

}
