public class Session {
    private String token;
    private int role;

    public String getToken() {
        return token;
    }

    public Session(String token, int role) {
        this.token = token;
        this.role = role;
    }
    @Override
    public String toString() {
        return "Session{" +
                "token='" + token + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
