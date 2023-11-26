package com.simplilearn.estore.jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ADMINS database table.
 *
 */
@Entity
@Table(name="ADMINS")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int adminId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;

    private String email;

    private String fullName;

    private int loginType;

    private String password;

    public Admin() {
    }

    public int getAdminId() {
        return this.adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Date getAddedOn() {
        return this.addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}