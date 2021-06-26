package diproj.signups;

public class Information {

    private String name;
    private String uname;
    private String psw;
    private String role;
    private String phone_no;

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

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", uname='" + uname + '\'' +
                ", psw='" + psw + '\'' +
                ", role='" + role + '\'' +
                ", phone_no='" + phone_no + '\'' +
                '}';
    }
}
