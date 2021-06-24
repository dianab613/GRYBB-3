package grybb.src.main.java;

public class Queries {
    static final public String query1 = "SELECT password FROM people WHERE name = ?";
    static final public String query2 = "SELECT name from people WHERE name = ?";
    static final public String query3 = "SELECT role from people WHERE name = ? AND password = ?";

    // employee lookup table
    static final public String query4 = "SELECT p.name, e.working_hours\n" +
                                        "FROM people p , employee e\n" +
                                        "WHERE p.person_id = e.person_id";

}
