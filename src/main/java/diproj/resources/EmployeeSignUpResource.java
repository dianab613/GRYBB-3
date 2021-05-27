package diproj.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import diproj.dao.Employees;
import diproj.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/signupform-employee")
public class EmployeeSignUpResource {
    private Employee employee;
    private Map<Integer,String> emps = new HashMap<>();
    private int i = 0;

    public EmployeeSignUpResource(){
    }

    public EmployeeSignUpResource(String fname, String lname, String uname, String psw){
        this.employee = new Employee();
        employee.setName(fname + " " + lname);
        employee.setEmail(uname);
        employee.setPassword(psw);
        employee.setPid(this.i);
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
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
            }
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(){
        return Employees.instance.getModel();
    }



}
