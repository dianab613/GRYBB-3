package diproj.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import diproj.model.Person;
import diproj.dao.People;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/signupform-municipality")
public class MunicipalitySignUpResource {
    private Person person;
    private Map<Integer, String> ppl = new HashMap<>();
    private int i = 0;

    private MunicipalitySignUpResource(){}

    private MunicipalitySignUpResource(String fname, String lname, String uname, String psw){
        this.person = new Person();
        person.setName(fname + " " + lname);
        person.setEmail(uname);
        person.setPassword(psw);
        person.setPid(this.i);
        person.setRole("municipality");
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createManager(String fname, String lname, String uname, String psw){
        for(Map.Entry e : ppl.entrySet()){
            if(uname.equals(e.getValue())){
                System.out.println("Username already taken. Please choose another.");
            }
            else{
                i++;
                ppl.put(i, uname);
                MunicipalitySignUpResource em = new MunicipalitySignUpResource(fname, lname, uname, psw);
                People.instance.getModel().add(this.person);
            }
        }
    }

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
