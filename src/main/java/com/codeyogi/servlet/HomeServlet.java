package com.codeyogi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeyogi.dao.StudentDAO;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("student", new StudentDAO().getStudent(studentId));
		
		RequestDispatcher rd = request.getRequestDispatcher("student-details.jsp");
		rd.forward(request, response);
	}
}
