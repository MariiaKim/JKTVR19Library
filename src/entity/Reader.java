/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pupil
 */
public class Reader {
    private String fistname;
    private String lastname;
    private Integer phone;

    public Reader() {
    }

    public Reader(String fistname, String lastname, Integer phone) {
        this.fistname = fistname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Reader{" + "fistname=" + fistname + ", lastname=" + lastname + ", phone=" + phone + '}';
    }
    
}
