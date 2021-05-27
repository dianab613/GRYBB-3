package main.java;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet{
    int role;
    public Login(int role){
        // 1 = field worker
        // 2 = manager
        // 3 = municipality officer
        this.role = role;
    }

public boolean validateLogin(String username, String password){
    boolean login = false;
    String host = "bronto.ewi.utwente.nl";
    String dbName = "dab_di20212b_224";
    String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
        PreparedStatement statement = connection.prepareStatement(Queries.query3);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet rs1 = statement.executeQuery();


        if (rs1.next() != false) {
            switch (role) {
                case 0:
                    if (rs1.getString(1).equals("Field Engineer")) {
                        login = true;
                        break;
                    }
                case 1:
                    if (rs1.getString(1).equals("Manager")) {
                        login = true;
                        break;
                    }
                case 2:
                    if (rs1.getString(1).equals("Municipality Officer")) {
                        login = true;
                        break;
                    }
                default:
                    login = false;

            }

        }
        return login;


    }

    catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }







       return login;
}

}
