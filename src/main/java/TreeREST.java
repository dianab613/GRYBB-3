import diproj.signups.Tree;
import diproj.signups.resources.tools.DBConnection;
import diproj.signups.resources.tools.Queries;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/trees")
public class TreeREST {
public TreeREST(){

}
@Path("/treesonmap")
@GET
@Produces(MediaType.APPLICATION_JSON)
    public List<Tree> getTrees(){
    List<Tree> treeList = new ArrayList<>();
    try {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.createConnection();
        PreparedStatement statement = connection.prepareStatement(Queries.query8);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            Tree tree = new Tree();
            tree.setId(rs.getInt(1));
            tree.setWlevel(rs.getInt(2));
            treeList.add(tree);
        }
    } catch(SQLException e){

    }

    return treeList;
}

}
