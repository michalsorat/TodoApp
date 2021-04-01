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
    private Long id;
    private String note;
    private String rg;
    private String ug;
    private boolean favourite;

    public Note() {
    }

    public Note(Long id, String note, String rg, String ug, boolean favourite) {
        this.id = id;
        this.note = note;
        this.rg = rg;
        this.ug = ug;
        this.favourite = favourite;
    }

    public Note(String note, String rg, String ug, boolean favourite) {
        this.note = note;
        this.rg = rg;
        this.ug = ug;
        this.favourite = favourite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFrom() {
        return rg;
    }

    public void setFrom(String from) {
        this.rg = from;
    }

    public String getTo() {
        return ug;
    }

    public void setTo(String to) {
        this.ug = to;
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
                ", note='" + note + '\'' +
                ", from='" + rg + '\'' +
                ", to='" + ug + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}
