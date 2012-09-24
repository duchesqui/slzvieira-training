import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String corFundo = getInitParameter("backcolor");
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Empresa Tabajara</title>");
        out.println("</head>");
        out.println("<body bgcolor='" + corFundo + "'>");
        out.println("Bem vindo ao site da Empresa Tabajara");
        out.println("</body>");
        out.println("<html>");
    }
}
