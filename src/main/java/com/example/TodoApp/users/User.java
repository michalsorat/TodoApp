package com.example.TodoApp.users;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id;
    private String name;
    private String password;
    private String email;
//    @Transient
//    private String reg_date;

    private LocalDate reg_date;
    public User() {
    }

    public User(Long id, String name, String password, String email /*,String reg_date*/) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.reg_date = LocalDate.now();
       // this.reg_date = reg_date;
    }

    public User(String name, String password, String email/*, String reg_date*/) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.reg_date = LocalDate.now();
        //this.reg_date = reg_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public LocalDate getReg_date() {

        return reg_date;
    }
    public void setReg_date(LocalDate reg_date) {

        this.reg_date = reg_date;
    }


    /*public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }*/

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registration_date='" + reg_date + '\'' +
                '}';
    }
}
