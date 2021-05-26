package diproj.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import diproj.dao.Employees;
import diproj.model.Employee;
import diproj.model.Person;
import diproj.dao.People;

import java.util.ArrayList;
import java.util.List;

@Path("/signupform-municipality")
public class MunicipalitySignUpResource {
    private String email;
    private String password;
    private Person person;

    private MunicipalitySignUpResource(){}

    private MunicipalitySignUpResource(String email, String password){
        this.person = new Person();
        person.setEmail(email);
        person.setPassword(password);
    }


//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createMunicipality(){
//     not sure how to create an person using just username and password
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getMunicipality(){
        List<Person> municipality = new ArrayList<>();
        List<Person> p = People.instance.getModel();
        for(Person pers : p) {
            if(pers.getRole().equals("municipality")){
                municipality.add(pers);
            }
        }
        return municipality;
    }

}
