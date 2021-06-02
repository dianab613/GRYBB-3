package main.java;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

    private String name;
    private String HashPass;

    public Credentials(){

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getHashPass() {
        return HashPass;
    }
    public void setHashPass(String hashPass) {
        HashPass = hashPass;
    }


}
