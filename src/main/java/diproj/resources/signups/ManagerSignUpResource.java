package diproj.resources.signups;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import diproj.model.Person;
import diproj.dao.People;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/signupform-manager")
public class ManagerSignUpResource {
    private Person person;
    private Map<Integer, String> ppl = new HashMap<>();
    private int i = 0;

    private ManagerSignUpResource(){}

    private ManagerSignUpResource(String fname, String lname, String uname, String psw){
        this.person = new Person();
        person.setName(fname + " " + lname);
        person.setEmail(uname);
        person.setPassword(psw);
        person.setPid(this.i);
        person.setRole("manager");
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createManager(String fname, String lname, String uname, String psw){
        for(Map.Entry e : ppl.entrySet()){
            if(uname.equals(e.getValue())){
//                System.out.println("Username already taken. Please choose another.");
            }
            else{
                i++;
                ppl.put(i, uname);
                ManagerSignUpResource em = new ManagerSignUpResource(fname, lname, uname, psw);
                People.instance.getModel().add(this.person);
            }
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getManager(){
        List<Person> manager = new ArrayList<>();
        List<Person> p = People.instance.getModel();
        for(Person pers : p) {
            if(pers.getRole().equals("manager")){
                manager.add(pers);
            }
        }
        return manager;
    }

}
