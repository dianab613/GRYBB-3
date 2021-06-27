package diproj.signups.resources.employee;

import diproj.signups.Tree;
import diproj.signups.resources.tools.DBConnection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Path("/employee_portal_map")
public class EmployeePortalResource {

    public EmployeePortalResource(){}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/watering/water")
    public boolean water(Tree tree) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.createConnection();
        try{
            String date = Calendar.getInstance().getTime().toString();
            String sql = "UPDATE tree\n" +
                    "SET water_level = water_level + ?, \n" +
                    "last_watered = ?\n" +
                    "WHERE tree_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, tree.getWlevel());
            statement.setString(2, date);
            statement.setInt(3, tree.getId());
            statement.executeUpdate();
        }
        catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
            return false;
        }
        connection.close();
        return true;
    }

}
