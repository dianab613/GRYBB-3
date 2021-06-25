import java.sql.*;

public class Login {

    public Login() {

    }

    public boolean validateLogin(String username, String password) {
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";
        Hash hash = new Hash();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            PreparedStatement statement = connection.prepareStatement(Queries.query1);
            statement.setString(1, username);

            ResultSet rs1 = statement.executeQuery();

            if (rs1.next()) {
                String userpass = rs1.getString(1);
                if (hash.matchPass(password, userpass)) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
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
                        return 1;
                    case "Manager":
                        return 2;
                    case "Municipality":
                        return 3;
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }
}