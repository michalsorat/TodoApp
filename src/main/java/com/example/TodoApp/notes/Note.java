package com.example.TodoApp.notes;

import com.example.TodoApp.users.User;

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
    private String description;
    private String fromDate;
    private String toDate;
    private boolean favourite;

    public Note() {
    }

    public Note(String note, String description, String fromDate, String toDate, boolean favourite) {
        this.note = note;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.favourite = favourite;
    }

    public Note(long id, long user_id, String note, String description, String fromDate, String toDate, boolean favourite) {
        this.id = id;
        this.user_id = user_id;
        this.note = note;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.favourite = favourite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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
                ", user_id=" + user_id +
                ", note='" + note + '\'' +
                ", description='" + description + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}


