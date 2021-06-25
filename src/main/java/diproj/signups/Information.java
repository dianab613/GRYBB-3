package diproj.signups;

public class Information {

    public String name;
    public String uname;
    public String psw;
    public String role;

    public Information(){
    }

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public String getUname() {
        return uname;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", uname='" + uname + '\'' +
                ", psw='" + psw + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
