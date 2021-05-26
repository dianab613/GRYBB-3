package diproj.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import diproj.dao.Employees;
import diproj.model.Employee;

import java.util.List;

@Path("/signupform-employee")
public class EmployeeSignUpResource {
    private String email;
    private String password;
    private Employee employee;

    public EmployeeSignUpResource(){
    }

    public EmployeeSignUpResource(String email, String password){
        this.employee = new Employee();
        employee.setEmail(email);
        employee.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void createEmployee(){
//     not sure how to create an employee using just username and password
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(){
        return Employees.instance.getModel();
    }



}
