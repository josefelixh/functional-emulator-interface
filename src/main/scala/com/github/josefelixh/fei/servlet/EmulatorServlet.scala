package com.github.josefelixh.fei.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class EmulatorServlet extends HttpServlet {

	override def service(request: ServletRequest, response: ServletResponse) {
	  response.getWriter().write("Hello scala world");
	}

}