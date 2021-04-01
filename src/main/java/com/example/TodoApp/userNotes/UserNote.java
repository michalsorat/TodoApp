package com.example.TodoApp.userNotes;

public class UserNote {
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
