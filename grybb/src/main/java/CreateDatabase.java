package main.java;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class CreateDatabase {

    public static void main(String[] args){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        String username = "e";
        Scanner myObj = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");


            String sql =
                    "DROP TABLE IF EXISTS company CASCADE;" +
                            "CREATE TABLE company (" +
                            "Company_id int, " +
                            "Name TEXT, " +
                            "Description text, " +
                            "PRIMARY KEY (Company_id) " +
                            ");";
            String sql2 = "DROP TABLE IF EXISTS tree CASCADE ;" +
                    "CREATE TABLE tree (" +
                    "Tree_id int," +
                    "Species TEXT, " +
                    "Height float, " +
                    "Year_planted smallint, " +
                    "Water_level int, " +
                    "Company_id int, " +
                    "Location text, " +
                    "Alive bit, " +
                    "Last_watered date, " +
                    "PRIMARY KEY (Tree_id), " +
                    "FOREIGN KEY (Company_id) REFERENCES company(Company_id) " +
                    "); ";
            String sql3 = "DROP TABLE IF EXISTS people CASCADE ;" +
                    "CREATE TABLE people ( " +
                    "Person_id int, " +
                    "Name text, " +
                    "Password varchar, " +
                    "Phone_number varchar(10), " +
                    "Email text, " +
                    "Role text, " +
                    "PRIMARY KEY (Person_id) " +
                    "); ";
            String sql4 = "DROP TABLE IF EXISTS employee CASCADE ;" +
                    "CREATE TABLE employee ( " +
                    "Person_id int, " +
                    "Working_hours text, " +
                    "Last_active date, " +
                    "Area text, " +
                    "CONSTRAINT PK_Employee PRIMARY KEY (Person_id,area)," +
                    "FOREIGN KEY (Person_id) REFERENCES people(Person_id) " +
                    ");";
            String Dirk = "INSERT INTO people (Person_id, Name, Password, Phone_number, Email, Role) \n" +
                    "VALUES (1,'Dirk van de Ruit', 'GrybbTeam3','0637557119', 'dirk.vanderuit@gmail.com', 'Field Engineer');";


            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            statement.executeUpdate(Dirk);
            connection.close();

        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
            System.exit(0);
        }


    }
}
