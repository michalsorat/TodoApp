package com.example.TodoApp.users;

import com.example.TodoApp.notes.Note;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
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
    private long id;
    private String name;
    private String password;
    private String email;
    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Note> notes = new ArrayList<>();*/
//    @Transient
//    private String reg_date;

    private LocalDate reg_date;
    @Lob
    private byte[] image;

    public User() {
    }

    public User(long id, String name, String password, String email, byte[] image) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.reg_date = LocalDate.now();
        this.image = image;
    }

    public User(String name, String password, String email, byte[] image) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.reg_date = LocalDate.now();
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getReg_date() {

        return reg_date;
    }


    /*public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }*/

    public void setReg_date(LocalDate reg_date) {
        this.reg_date = reg_date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
