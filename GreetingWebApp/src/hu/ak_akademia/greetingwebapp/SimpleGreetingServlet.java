package hu.ak_akademia.greetingwebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleGreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String timeOfDay = request.getParameter("timeOfDay");
		String greetingText = "Jó ";
		switch (timeOfDay) {
		case "morning":
			greetingText += "reggelt";
			break;
		case "evening":
			greetingText += "estét";
			break;
		case "night":
			greetingText += "éjszakát";
			break;
		}
		greetingText += " " + firstName + "!";
		out.append(greetingText);
	}

}
