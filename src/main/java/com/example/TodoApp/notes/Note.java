package com.example.TodoApp.notes;

import javax.persistence.*;

@Entity
@Table(name="note")
public class Note {
    @Id
    @SequenceGenerator(
            name = "notes_sequence",
            sequenceName = "notes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notes_sequence"
    )
    private long id;
    private long user_id;
    private String note;
    private String od;
    private String platnost;
    private boolean favourite;

    public Note() {
    }

    public Note(long id, long user_id, String note, String od, String platnost, boolean favourite) {
        this.id = id;
        this.user_id = user_id;
        this.note = note;
        this.od = od;
        this.platnost = platnost;
        this.favourite = favourite;
    }

    public Note(String note, String od, String platnost, boolean favourite) {
        this.note = note;
        this.od = od;
        this.platnost = platnost;
        this.favourite = favourite;
    }

    public Note(String name, String note, String from, String to, boolean favourite) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFrom() {
        return od;
    }

    public void setFrom(String od) {
        this.od = od;
    }

    public String getTo() {
        return platnost;
    }

    public void setTo(String platnost) {
        this.platnost = platnost;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", note='" + note + '\'' +
                ", from='" + od + '\'' +
                ", to='" + platnost + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}
