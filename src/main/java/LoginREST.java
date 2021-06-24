import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/account")
public class LoginREST {
    public LoginREST() {
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Session myLoginREST(Credentials credentials) {
        System.out.println(credentials.getUsername()+" "+ credentials.getPassword());
        Login log = new Login();
        if (log.validateLogin(credentials.getUsername(), credentials.getPassword())) {
            return new Session("token", log.getRole(credentials.getUsername(), credentials.getPassword()));
        }
        else {
            return new Session("token", -1);
        }
    }
}