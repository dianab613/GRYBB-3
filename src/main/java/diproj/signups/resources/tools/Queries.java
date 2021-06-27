package diproj.signups.resources.tools;

public class Queries {
    static final public String query1 = "SELECT password FROM people WHERE email = ?";
    static final public String query2 = "SELECT name from people WHERE name = ?";
    static final public String query3 = "SELECT role from people WHERE email = ?";

    // employee lookup table
    static final public String query4 = "SELECT p.name, e.working_hours\n" +
                                        "FROM people p , employee e\n" +
                                        "WHERE p.person_id = e.person_id";

    static  final public String query4V2 = "SELECT XMLElement(NAME employees, XMLAGG(rows))\n" +
            "FROM(\n" +
            "SELECT p.person_id, XMLELEMENT(NAME Employee, XMLFOREST(P.name, e.working_hours)) AS rows\n" +
            "FROM people p, employee e\n" +
            "WHERE p.person_id = e.person_id\n" +
            "ORDER BY p.person_id) AS test";
    static final public String query5 = "INSERT INTO employee VALUES (?,'09:00-17:00', NULL, '-')";
}
