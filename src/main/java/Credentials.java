import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

    private String email;
    private String password;

    public Credentials(){

    }

    @Override
    public String toString() {
        return "Credentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String hashPass) {
        password = hashPass;
    }


}
