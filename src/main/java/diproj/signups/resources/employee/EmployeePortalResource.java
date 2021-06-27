package diproj.signups.resources.employee;

import diproj.signups.Tree;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Path("/employee_portal_map")
public class EmployeePortalResource {

    public EmployeePortalResource(){}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/details")
    public List<Tree> filterTrees(String filter){
        List<Tree> trees = new ArrayList<>();
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String password = "sH9CxfLuJtu60On2";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, password);
            Statement statement = connection.createStatement();
        String sqlUtsq = "ALTER TABLE tree DROP COLUMN IF EXISTS attributes" +
                "ALTER TABLE tree ADD COLUMN attributes tsvector;\n" +
                "UPDATE tree\n" +
                "SET attributes = to_tsvector('simple', coalesce(species,'') "+
                "|| ' ' || coalesce(height::text,'')|| ' ' || coalesce(year_planted::text,'')"+
                "|| ' ' || coalesce(water_level::text,'')|| ' ' || coalesce(location,'')"+
                "|| ' ' || coalesce(last_watered::text,''))";
        statement.executeUpdate(sqlUtsq);
        String sqlS = "SELECT tree_id\n" +
                "FROM tree\n" +
                "WHERE attributes @@ to_tsquery('"+ filter+"')";
            ResultSet rs = statement.executeQuery(sqlS);
            while(rs.next()){
                Tree t = new Tree();
                t.setId(rs.getInt("tree_id"));

                t.setWlevel(rs.getInt("water_level"));

                trees.add(t);
            }
    } catch(Exception E) {
            E.printStackTrace();
            System.err.println(E.getClass().getName() + ": " + E.getMessage());
        }
        return trees;
    }
}
