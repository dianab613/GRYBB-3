import diproj.signups.resources.tools.Queries;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;

@Path("/manager_portal_employees")
@XmlRootElement
public class EmployeeLookUpREST {

    @GET
    @Path("/lookup")
    @Produces(MediaType.APPLICATION_XML)
    public String EmployeeLookUpREST(){

        String result = null;

        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String url = "jdbc:postgresql://" + host + ":5432/" + dbName + "?currentSchema=grybb";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, "sH9CxfLuJtu60On2");
            PreparedStatement statement = connection.prepareStatement(Queries.query4V2);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               result = rs.getString(1);
            }
            rs.close();
            statement.close();
            connection.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
