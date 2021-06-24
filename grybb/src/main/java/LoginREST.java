package grybb.src.main.java;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;

@Path("/RESTlogin")
@XmlRootElement
public class LoginREST {
    public LoginREST() {
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean myLoginREST(Credentials credentials) {

        Login log = new Login(0);
        return log.validateLogin(credentials.getUname(), credentials.getPword());

    }
}