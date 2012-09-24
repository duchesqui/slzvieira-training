import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/olamundo")
public class OlaMundoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        SimpleDateFormat mascara = new SimpleDateFormat("HH:mm:ss");
        Date agora = new Date();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ola, mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ol&aacute; Mundo</h1>");
        out.println("S&atilde;o exatamente " + mascara.format(agora));
        out.println("</body>");
        out.println("</html>");
    }
}
