package gr.hua.dit.ds.BloodDonorApp.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    @NotBlank
    private String first_name;
    @Column
    @NotBlank
    private String last_name;
    @Column
    @NotBlank
    private String dateOfBirth;
    @Column
    @NotBlank
    private String sex;
    @Column
    @NotBlank
    private String phoneNumber;
    @Column
    @NotBlank
    private String email;


    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn
    private User user;

    public Profile() {
    }

    public Profile(String first_name, String last_name, String dateOfBirth, String sex, String phoneNumber, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
