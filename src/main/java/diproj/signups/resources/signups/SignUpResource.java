package diproj.signups.resources.signups;

import diproj.signups.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/signupform")
public class SignUpResource {
    private Employee employee;
    private Map<Integer,String> emps = new HashMap<>();
    private int i;
    private Person person;
    private Map<Integer, String> ppl = new HashMap<>();

    public SignUpResource(){
    }

    public SignUpResource(String fname, String lname, String uname, String psw, String role){
        this.person = new Person();
        person.setName(fname + " " + lname);
        person.setEmail(uname);
        person.setPassword(psw);
        person.setPid(this.i);
        person.setRole(role);
        if(role=="employee"){
            employee.setPid(i);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public boolean createUser(Information information){
        for(Map.Entry p : ppl.entrySet()){
            if(information.getUname().equals(p.getValue())){
                return false;
            }
            else {
                i++;
                ppl.put(i, information.getUname());
                People.instance.getModel().add(this.person);
                String role;
                addPerson(this.person);
            }
        }
        return true;
    }


    public List<Employee> getEmployees(){
        return Employees.instance.getModel();
    }


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

    public void addPerson(Person person){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String password = "sH9CxfLuJtu60On2";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, password);
            Statement statement = connection.createStatement();
            String name = person.getName();
            String phone = person.getTelephone();
            String uname = person.getEmail();
            String psw = person.getPassword();
            String role = person.getRole();
            String sql = "UPDATE TABLE people (i, name, phone, uname, psw, role)";
            statement.executeUpdate(sql);
        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
        }
    }

    private void addEmployee(){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String password = "sH9CxfLuJtu60On2";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE TABLE employee (i, '-', NULL, '-')";
            statement.executeUpdate(sql);
        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
        }
    }
}
