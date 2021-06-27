package diproj.signups.resources.signups;

import diproj.signups.*;
import diproj.signups.resources.tools.DBConnection;
import diproj.signups.resources.tools.Hash;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/signupform")
public class SignUpResource {
    private Employee employee;
    private Map<Integer,String> emps = new HashMap<>();
    private int i;
    private Person person;
    private Map<Integer, String> ppl = new HashMap<>();

    public SignUpResource(){
    }

    public SignUpResource(String fname, String lname, String uname, String psw, String role){
        this.person = new Person();
        person.setName(fname + " " + lname);
        person.setEmail(uname);
        person.setPassword(psw);
        person.setPid(this.i);
        person.setRole(role);
        if(role=="employee"){
            employee.setPid(i);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String createUser(Information information) throws SQLException {
        System.out.println("lol");
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.createConnection();
        Hash hash = new Hash();


        PreparedStatement state = connection.prepareStatement("SELECT person_id FROM people WHERE email = ?;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        state.setString(1, information.getUname());
        PreparedStatement state2 = connection.prepareStatement("SELECT person_id FROM people;");
        ResultSet rs = state.executeQuery();
        ResultSet rs1 = state2.executeQuery();
        int rows = 0;
        if (rs.next()){
            return "false";
        }
        else{
            while (rs1.next()){
                int pid = rs1.getInt(1);
                rows++;
            }

        }
        System.out.println(rows);
        addPerson(connection, rows+1, information.getName(), hash.hashPassword(information.getPsw()), information.getPhone_no(), information.getUname(), information.getRole());
        return "true";
    }


    public List<Employee> getEmployees(){
        return Employees.instance.getModel();
    }


    public List<Person> getMunicipality(){
        List<Person> municipality = new ArrayList<>();
        List<Person> p = People.instance.getModel();
        for(Person pers : p) {
            if(pers.getRole().equals("municipality")){
                municipality.add(pers);
            }
        }
        return municipality;
    }


    public List<Person> getManager(){
        List<Person> manager = new ArrayList<>();
        List<Person> p = People.instance.getModel();
        for(Person pers : p) {
            if(pers.getRole().equals("manager")){
                manager.add(pers);
            }
        }
        return manager;
    }

    public void addPerson(Connection connection, int person_id, String name, String password, String phone, String email, String role){
        try{
            String sql = "INSERT INTO people (person_id, name, password, phone_number, email, role) values (?, ?, ?, ? ,?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, person_id); statement.setString(2, name); statement.setString(3, password);
            statement.setString(4, phone); statement.setString(5, email); statement.setString(6, role);
            statement.executeUpdate();
        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
        }
    }

    private void addEmployee(){
        String host = "bronto.ewi.utwente.nl";
        String dbName = "dab_di20212b_224";
        String password = "sH9CxfLuJtu60On2";
        String url = "jdbc:postgresql://" + host + ":5432/" +  dbName + "?currentSchema=grybb";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbName, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "UPDATE TABLE employee (i, '-', NULL, '-')";
            statement.executeUpdate(sql);
        } catch(Exception E){
            E.printStackTrace();
            System.err.println(E.getClass().getName()+": "+ E.getMessage());
        }
    }
}
