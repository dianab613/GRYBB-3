import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

    private String username;
    private String password;

    public Credentials(){

    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUsername(String name) {
        this.username = name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String hashPass) {
        password = hashPass;
    }


}
