package model;

import java.util.Date;

public class Employee extends Person{
    private String working_hours;
    private Date last_active;
    private String area;

    public Employee(){
    }

    public Employee(String working_hours, Date last_active, String area){
        setWorking_hours(working_hours);
        setLast_active(last_active);
        setArea(area);
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
}
