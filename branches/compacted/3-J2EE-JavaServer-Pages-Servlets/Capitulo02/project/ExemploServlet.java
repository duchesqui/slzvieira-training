import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExemploServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    SimpleDateFormat mascara = new SimpleDateFormat("HH:mm:ss");
		Date agora = new Date();
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Ol&aacute; Mundo</title></head>");
		out.println("<body>S&atilde;o exatamente " + mascara.format(agora) + "</body></html>");
	}
}
