package diproj.signups.resources.tools;


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Queries {
    static final public String query1 = "SELECT password FROM people WHERE email = ?";
    static final public String query2 = "SELECT name from people WHERE name = ?";
    static final public String query3 = "SELECT role from people WHERE email = ?";

    // employee lookup table
    static final public String query4 = "SELECT p.name, e.working_hours\n" +
            "FROM people p , employee e\n" +
            "WHERE p.person_id = e.person_id";

    static final public String query4V2 = "SELECT XMLElement(NAME employees, XMLAGG(rows))\n" +
            "FROM(\n" +
            "SELECT p.person_id, XMLELEMENT(NAME Employee, XMLFOREST(P.name, e.working_hours, e.last_active)) AS rows\n" +
            "FROM people p, employee e\n" +
            "WHERE p.person_id = e.person_id\n" +
            "ORDER BY p.person_id) AS test";
    static final public String query5 = "INSERT INTO employee VALUES (?,'09:00-17:00', NULL, '-')";

    static Hash hash = new Hash();

     static String query6;

    public static String FillDB(String i, String name, String password, String number, String email, String role, String hours, String active, String area) throws NoSuchAlgorithmException {
        query6 = "INSERT INTO person (person_id, name ,password, phone_number, email, role)\n" +
                "VALUES(" + i + ", " + name + ", " + hash.hashPassword(password) + ", " + number + ", " + email + ", " + role + ")";
        if (role.equals("Field Engineer")) {
            query6 = query6 + "\n INSERT INTO employee(person_id, working_hours, last_active, area) \n" +
                    "VALUES (" + i + ", " + hours + ", " + active + ", " + area + ")";
        }
        return query6;
    }

    public static void main(String[] args){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        String username = "e";
        Scanner myObj = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");


            String sql = FillDB("100","Peter", "Hallo123", "0692964771", "Peter@manager.com", "Manager", "", "", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();


    }catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
            System.exit(0);
        }
}}
