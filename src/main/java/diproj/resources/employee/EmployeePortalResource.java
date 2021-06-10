package diproj.resources.employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.sql.*;

@Path("/employee_portal")
public class EmployeePortalResource {

    public EmployeePortalResource(){}

    @POST
//    @Consumes(MediaType.TEXT_HTML)
//    @Produces(MediaType.TEXT_HTML)
    public void filterTrees(String filter){
        String sqlUtsq = "ALTER TABLE tree ADD COLUMN attributes tsvector;\n" +
                "UPDATE tree\n" +
                "SET attributes = to_tsvector('simple', coalesce(species,'') "+
                "|| ' ' || coalesce(height::text,'')|| ' ' || coalesce(year_planted::text,'')"+
                "|| ' ' || coalesce(water_level::text,'')|| ' ' || coalesce(location,'')"+
                "|| ' ' || coalesce(last_watered::text,''))";
        String sqlS = "SELECT tree_id\n" +
                "FROM tree\n" +
                "WHERE attributes @@ to_tsquery('"+ filter+"')";
    }
}
