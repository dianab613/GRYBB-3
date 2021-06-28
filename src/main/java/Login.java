import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Calendar;

import diproj.signups.resources.tools.Hash;
import diproj.signups.resources.tools.Queries;

public class Login {

    public Login() {

    }

    public boolean validateLogin(String email, String password) {
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";
        Hash hash = new Hash();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            PreparedStatement statement = connection.prepareStatement(Queries.query1);
            statement.setString(1, email);

            ResultSet rs1 = statement.executeQuery();

            if (rs1.next()) {
                String userpass = rs1.getString(1);
                if (hash.matchPass(password, userpass)) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int getRole(String username) {
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            PreparedStatement statement = connection.prepareStatement(Queries.query3);
            statement.setString(1, username);

            ResultSet rs1 = statement.executeQuery();


            if (rs1.next()) {
                String role = rs1.getString(1);
                switch (role){
                    case "Field Engineer":
                        setLastActive(connection, username);
                        connection.close();
                        return 1;
                    case "Manager":
                        return 2;
                    case "Municipality":
                        return 3;
                }
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public void setLastActive(Connection connection, String email) throws SQLException {
        String date = Calendar.getInstance().getTime().toString();
        PreparedStatement statement = connection.prepareStatement(Queries.query6);
        statement.setString(1, date);
        statement.setString(2, email);
        statement.executeUpdate();
        connection.close();
    }
}