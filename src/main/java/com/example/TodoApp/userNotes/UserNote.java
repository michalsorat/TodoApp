package com.example.TodoApp.userNotes;

import javax.persistence.*;

@Entity
@Table(name="userNote")
public class UserNote {
    @Id
    @SequenceGenerator(
            name = "userNotes_sequence",
            sequenceName = "userNotes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userNotes_sequence"
    )
    private Long userId;
    private Long noteId;

    public UserNote() {
    }

    public UserNote(Long userId, Long noteId) {
        this.userId = userId;
        this.noteId = noteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    @Override
    public String toString() {
        return "UserNote{" +
                "userId=" + userId +
                ", noteId=" + noteId +
                '}';
    }
}
