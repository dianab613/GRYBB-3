package diproj.model;

public class Person {
    private int pid;
    private String name;
    private String telephone;
    private String email;
    private String password;
    private String role;

    public Person(){
    }

    public Person(int pid, String name, String email, String password, String role){
        setPid(pid);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
        setTelephone(null);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
