package model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    @Email
    private String email;

    public Address() {
    }

    public Address(int user_id, String phone, String email) {
        this.user_id = user_id;
        this.phone = phone;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
