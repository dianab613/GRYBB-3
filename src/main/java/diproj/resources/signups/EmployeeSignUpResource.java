package diproj.resources.signups;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.sql.*;

import diproj.dao.Employees;
import diproj.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("signupform-employee")
public class EmployeeSignUpResource {
    private Employee employee;
    private Map<Integer,String> emps = new HashMap<>();
    private int i = 0;

    public EmployeeSignUpResource(){
    }

    public EmployeeSignUpResource(String fname, String lname, String uname, String psw){
        this.employee = new Employee();
        employee.setName(fname + " " + lname);
        employee.setTelephone(null);
        employee.setEmail(uname);
        employee.setPassword(psw);
        employee.setPid(this.i);
    }



    @POST
    @Consumes(MediaType.TEXT_HTML)
    public void createEmployee(String fname, String lname, String uname, String psw){
        for(Map.Entry e : emps.entrySet()){
            if(uname.equals(e.getValue())){
               System.out.println("Username already taken. Please choose another.");
            }
            else{
                i++;
                emps.put(i, uname);
               EmployeeSignUpResource em = new EmployeeSignUpResource(fname, lname, uname, psw);
                Employees.instance.getModel().add(this.employee);

                String host = "bronto.ewi.utwente.nl";
                String dbName = "dab_di20212b_224";
                String password = "sH9CxfLuJtu60On2";
                String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
                try{
                    Class.forName("org.postgresql.Driver");
                    Connection connection = DriverManager.getConnection(url, dbName, password);
                    Statement statement = connection.createStatement();
                    String name = fname + lname;
                    String updquery = "UPDATE TABLE people (i, name, null, uname, psw, 'employee')";
                    statement.executeUpdate(updquery);
                    String updquery2 = "UPDATE TABLE employee (i, '-', NULL, '-')";
                    statement.executeUpdate(updquery2);
                    Response.temporaryRedirect(URI.create("http://localhost:63342/GRYBB/src/main/webapp/Logins/loginemployee.html"));
                } catch(Exception E){
                    E.printStackTrace();
                    System.err.println(E.getClass().getName()+": "+ E.getMessage());
            }
        }
    }
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public List<Employee> getEmployees(){
        return Employees.instance.getModel();
    }



}
