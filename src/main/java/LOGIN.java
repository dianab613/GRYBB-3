import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Example of a Servlet that gets an ISBN number and returns the book price
 */

public class LOGIN extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private LoginChecker checker;

    public void init() throws ServletException {
        checker = new LoginChecker();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType =
                "<!DOCTYPE HTML>\n";
        String title = "Book Quote";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE>" +
                "<LINK REL=STYLESHEET HREF=\"styles.css\">" +
                "</HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>\n" +
                "  <P>ISBN number: " +
                request.getParameter("isbn") + "\n" +
                "  <P>Price: " +
                "</BODY></HTML>");
    }


}
