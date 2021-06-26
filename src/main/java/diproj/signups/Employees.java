package diproj.signups;

import java.util.ArrayList;
import java.util.List;

public enum Employees {
    instance;


    private List<Employee> emp = new ArrayList<>();

    private Employees(){}

    public List<Employee> getModel() {
        return emp;
    }

    public synchronized String addEmployee(String email, String password){
        Employee employee;
        boolean found = false;
        int i=0;
        while(!found && i < emp.size()){
            employee = emp.get(i);
            if(employee.getEmail().equals(email)){
                found = true;
                return "Account already created using this email.";
            }
            if(!found){
                Employee e = new Employee(People.instance.getModel().get(i));
                emp.add(e);
            }
        }
        return "Employee account created successfully.";
    }
}