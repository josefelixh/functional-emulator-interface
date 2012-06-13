package com.github.josefelixh.fei.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.Enumeration

class EmulatorServlet extends HttpServlet {

  def write (response: HttpServletResponse, toWrite: String) : Unit = {
    response.getWriter().write(toWrite)
    response.getWriter().write("\r")
  }
  
  def enumerate (response: HttpServletResponse, e: Enumeration[_]): Unit = {
    while(e.hasMoreElements()) {
      write (response, e.nextElement().toString())
    }
  }
  
	override def service(request: HttpServletRequest, response: HttpServletResponse) {
	  write(response, "Hello scala world")
	  
	  enumerate(response, request.getAttributeNames())
	  enumerate(response, request.getHeaderNames())
	  enumerate(response, request.getParameterNames())
	  
	  write(response, request.getRemoteHost())
	  write(response, request.getHeader("Host"))
	}
	
}