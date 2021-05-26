package model;

import java.util.Date;

public class Tree {
    private int id;
    private String species;
    private double height;
    private int year;
    private int wlevel;
    private int cid;
    private String location;
    private boolean alive;
    private Date lastw;

    public Tree(){
    }

    public Tree(int id, String species, double height, int year, int wlevel, int cid, String location, boolean alive, Date lastw){
        setId(id);
        setSpecies(species);
        setHeight(height);
        setYear(year);
        setWlevel(wlevel);
        setCid(cid);
        setLocation(location);
        setAlive(alive);
        setLastw(lastw);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWlevel() {
        return wlevel;
    }

    public void setWlevel(int wlevel) {
        this.wlevel = wlevel;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Date getLastw() {
        return lastw;
    }

    public void setLastw(Date lastw) {
        this.lastw = lastw;
    }
}
