package main.java;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

    private String uname;
    private String pword;

    public Credentials(){

    }

    public void setUname(String name) {
        this.uname = name;
    }
    public String getUname() {
        return uname;
    }
    public String getPword() {
        return pword;
    }
    public void setPword(String hashPass) {
        pword = hashPass;
    }


}
