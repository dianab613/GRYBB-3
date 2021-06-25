package diproj.signups;

import java.util.Date;

public class Employee extends Person{
    private String working_hours;
    private Date last_active;
    private String area;
    private Person person;


    public Employee(){
    }

    public Employee(Person person){
        setPerson(person);
        setWorking_hours("NO");
        setArea("NO");
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }

    public Date getLast_active() {
        return last_active;
    }

    public void setLast_active(Date last_active) {
        this.last_active = last_active;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
