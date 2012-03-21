package com.jfh.fei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmulatorServlet extends HttpServlet {
	private static final long serialVersionUID = 4394451567077842503L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("Hello world");
		resp.flushBuffer();
	}
	
	

}
