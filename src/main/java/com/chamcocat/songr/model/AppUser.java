package com.chamcocat.songr.model;

import org.springframework.security.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String passwordHash;

    public AppUser() {
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.setPassword(password);
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.passwordHash);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Made this method private to prevent external overwrite of password hash.
    private void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // This method will be used to update password
    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
