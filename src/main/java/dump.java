import java.sql.*;

public class dump {

    public static void main(String[] args){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            PreparedStatement statement = connection.prepareStatement(Queries.query3);
            statement.setString(1, "Chantal Jansen");
            statement.setString(2, "HelloEurope");

            ResultSet rs1 = statement.executeQuery();
            if (rs1.next()) {
                String role = rs1.getString(1);
                switch (role){
                    case "Field Engineer":
                        System.out.println("Field engineer");
                        break;
                    case "Manager":
                        System.out.println("Manager");
                        break;
                    case "Municipality":
                        System.out.println("Municipality");
                        break;
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
