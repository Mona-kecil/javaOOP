package entity;

enum Role {
    ADMIN("Administrator in charge of the application"),
    USER("User of the application");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class User {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;

    public User(String username, String password, String email, String firstName, String lastName) {
        this.username = username;
        this.password = this.hash(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = Role.USER;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = this.hash(password);
        this.role = Role.USER;
    }

    public User() {

    }

    // Password hashing function
    private String hash(String password) {
        Integer hash = 0;
        for (int i = 0; i < password.length(); i++)
        {
            hash += password.charAt(i);
        }
        return hash.toString();
    }

    // Getter and Setter methods
    public String getUserId() { return userId; }
    public void setUserId() {
        StringBuilder userId = new StringBuilder();
        userId.append(this.username.charAt(0));
        userId.append(this.username.charAt(1));
        Integer id = 0;
        for (int i = 0; i < this.username.length(); i++)
        {
            id += this.username.charAt(i);
        }
        if (id > 1000)
            id = id % 1000;
        else if (id < 10)
            id *= 100;
        else if (id < 100)
            id *= 10;
        
        userId.append(id.toString());
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        String hash = this.hash(password);
        this.password = hash;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Role getRole() { return role; }
}
