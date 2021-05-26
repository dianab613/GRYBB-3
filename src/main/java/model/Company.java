package model;

public class Company {
    private int cid;
    private String name;
    private String description;

    public Company(){
    }

    public Company(int cid, String name, String description){
        setCid(cid);
        setName(name);
        setDescription(description);
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
