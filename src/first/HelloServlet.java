/*
 * HelloServlet.java
 * Copyright: TsingSoft (c) 2015
 * Company: 北京清软创新科技有限公司
 */
package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service");
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		out.print(" <span style='color:red;'> hello world -service</span> <br> "
				+ " <a href='/dn01Servlet'> return index </a> ");
	}	
}
