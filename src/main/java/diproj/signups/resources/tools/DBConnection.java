package diproj.signups.resources.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public DBConnection(){

    }
    public Connection createConnection(){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            return connection;
        }
        catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
