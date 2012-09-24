import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContadorAcessosServlet extends HttpServlet {

    private int contador = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Contador de acessos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("Voc&ecirc; &eacute; o visitante de n&uacute;mero <b>" + ++contador + "</b> nesta p&aacute;gina");
        out.println("</html>");
    }
}
