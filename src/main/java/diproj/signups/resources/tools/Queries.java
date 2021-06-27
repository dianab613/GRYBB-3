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
        query6 = "INSERT INTO people (person_id, name ,password, phone_number, email, role)\n" +
                "VALUES('" + i + "', '" + name + "', '" + hash.hashPassword(password) + "', '" + number + "', '" + email + "', '" + role + "')";
        if (role.equals("Field Engineer")) {
            query6 = query6 + ";\n INSERT INTO employee(person_id, working_hours, last_active, area) \n" +
                    "VALUES ('"  + i + "', '" + hours + "', '" + active + "', '" + area + "')";
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


            String sql1 = FillDB("1","Peter Post", "Hallo123", "0692964771", "Peter@manager.com", "Manager", "", "", "");
            String sql2 = FillDB("2","Kees Jansma", "Cheese123", "0692964772", "Kees@municipality.com", "Municipality", "", "", "");
            String sql3 = FillDB("3","Amalia Bloemendaal", "Sausage123", "0692964773", "Amalia@employee.com", "Field Engineer", "9:00-17:00", "2021-06-10", "North");
            String sql4 = FillDB("4","Hagrid Grootmeester", "Wizard123", "0692964774", "Hagrid@employee.com", "Field Engineer", "9:00-17:00", "2021-05-16", "South");
            String sql5 = FillDB("5","Leo Blok", "grybb123", "0692964775", "Leo@employee.com", "Field Engineer", "9:00-17:00", "2021-05-19", "Mid");
            String sql6 = FillDB("6","Daan Hanraads", "toto123", "0692964776", "Daan@employee.com", "Field Engineer", "9:00-17:00", "2021-06-15", "West");
            String sql7 = FillDB("7","Dirk can de Ruit", "orange123", "0692964777", "Dirk@employee.com", "Field Engineer", "9:00-17:00", "2021-07-10", "East");
            String sql8 = FillDB("8","Diana Bozea", "Hello123", "0692964778", "Diana@employee.com", "Field Engineer", "10:00-19:00", "2021-05-19", "North");
            String sql9 = FillDB("9","Edina Depner", "Cheers123", "0692964779", "Edina@employee.com", "Field Engineer", "10:00-19:00", "2021-05-16", "South");
            String sql10 = FillDB("10","Rob Brommer", "Assist123", "0692964710", "Rob@employee.com", "Field Engineer", "10:00-19:00", "2021-05-13", "East");
            String sql11 = FillDB("11","Wouter Bos", "Goalsq123", "0692964711", "Wouter@employee.com", "Field Engineer", "10:00-19:00", "2021-05-12", "West");
            String sql12 = FillDB("12","Willem de Koning", "Crown123", "0692964712", "Willem@employee.com", "Field Engineer", "10:00-19:00", "2021-05-10", "Mid");
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            statement.executeUpdate(sql5);
            statement.executeUpdate(sql6);
            statement.executeUpdate(sql7);
            statement.executeUpdate(sql8);
            statement.executeUpdate(sql9);
            statement.executeUpdate(sql10);
            statement.executeUpdate(sql11);
            statement.executeUpdate(sql12);
            connection.close();


    }catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
            System.exit(0);
        }
}}
