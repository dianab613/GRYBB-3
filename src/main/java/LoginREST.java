import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/account")
public class LoginREST {
    public LoginREST() {
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Session myLoginREST(Credentials credentials) {
        Login log = new Login();
        if (log.validateLogin(credentials.getUsername(), credentials.getPassword())) {
            String uuid = UUID.randomUUID().toString();
            Session userSession = new Session(uuid, log.getRole(credentials.getUsername()));
            return userSession;
        }
        else {
            return new Session("token", -1);
        }
    }
}