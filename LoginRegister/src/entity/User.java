package entity;

import util.HashUtil;

public class User {
    private String username;
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        if (password != null)
            return this.password;
        return null;
    }
    void setPassword(String password) {
        this.password = HashUtil.hasher(password);
    }
}