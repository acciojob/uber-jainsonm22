
package com.driver.model;

import javax.persistence.*;

@Entity
@Table(name="admin")

public class Admin  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    private String Username;
    private  String password;

    public Admin() {
    }

    public Admin(String Username, String password) {
        this.Username = Username;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}