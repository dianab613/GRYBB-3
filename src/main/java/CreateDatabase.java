import java.sql.*;

public class CreateDatabase {
    public static void main(String[] args){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String password = "sH9CxfLuJtu60On2";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, password);
//        connection.setAutoCommit(false);

            String sql = "CREATE TABLE company (cid int, name varchar(50), description varchar(225), " +
                    "PRIMARY KEY (cid) );";
            String sql2 =  "CREATE TABLE tree (tid int, species varchar(50), height float, year_planted smallint, " +
                    "water_level int, cid int, location varchar(100), status bit, last_watered date, " +
                    "PRIMARY KEY (tid), " +
                    "FOREIGN KEY (cid) REFERENCES company(cid)); ";
            String sql3 = "CREATE TABLE people (pid int, name varchar(100), telephone varchar(10), " +
                    "email varchar(50), password varchar(20), role varchar(50), " +
                    "PRIMARY KEY (pid)); ";
            String sql4 = "CREATE TABLE employee (pid int, working_hours varchar(50), last_active date, area varchar(50), " +
                    "CONSTRAINT pk_employee PRIMARY KEY (pid,area), "+
                    "FOREIGN KEY (pid) REFERENCES people(pid));";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);

            System.out.println("Database has been successfully created.");
            connection.close();

        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
            System.exit(0);
        }


    }
}