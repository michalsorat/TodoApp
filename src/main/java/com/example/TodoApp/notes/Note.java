package com.example.TodoApp.notes;

public class Note {
    private Long id;
    private String note;
    private String from;
    private String to;
    private boolean favourite;

    public Note() {
    }

    public Note(Long id, String note, String from, String to, boolean favourite) {
        this.id = id;
        this.note = note;
        this.from = from;
        this.to = to;
        this.favourite = favourite;
    }

    public Note(String note, String from, String to, boolean favourite) {
        this.note = note;
        this.from = from;
        this.to = to;
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
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", favourite=" + favourite +
                '}';
    }
}
