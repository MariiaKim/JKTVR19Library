/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;
        
        
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author pupil
 */
@Entity
public class UserFacade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String role;
    @OneToOne
    private ReaderFacade reader;

    public UserFacade() {
    }

    public UserFacade(String login, String password, String role, ReaderFacade reader) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.reader = reader;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ReaderFacade getReader() {
        return reader;
    }

    public void setReader(ReaderFacade reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "User{" 
                + "login=" + login 
                + ", password=" + password 
                + ", role=" + role 
                + ", reader=" + reader.getFirstname()
                + " " + reader.getLastname()
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.login);
        hash = 19 * hash + Objects.hashCode(this.password);
        hash = 19 * hash + Objects.hashCode(this.role);
        hash = 19 * hash + Objects.hashCode(this.reader);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserFacade other = (UserFacade) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
        

}

