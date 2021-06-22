package main.java;

public class Queries {
    static final public String query1 = "SELECT password FROM people WHERE name = ?";
    static final public String query2 = "SELECT name from people WHERE name = ?";
    static final public String query3 = "SELECt role from people WHERE name = ? AND password = ?";
}
