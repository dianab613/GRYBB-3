package main.java;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/employeelogin")
public class EmployeeLogin extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
Login login = new Login(0);

boolean valid_login = login.validateLogin(request.getParameter("uname"), request.getParameter("psw"));

if (valid_login){
    response.sendRedirect("http://localhost:63342/GRYBB-3/main/webapp/welcomepagetest.html");
}
else {
    response.sendRedirect("http://localhost:63342/GRYBB-3/main/webapp/loginemployee.html");
}


pw.close();
}


}
