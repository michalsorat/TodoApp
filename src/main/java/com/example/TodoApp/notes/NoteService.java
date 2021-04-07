package com.example.TodoApp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /*public List<Note> getNotes(Long userID) {

        return noteRepository.findAll();
    }*/

    public void addNewNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        boolean exists = noteRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Note with id " + id + "does not exist");
        }
        noteRepository.deleteById(id);
    }

    @Transactional
    public void updateNote(Long noteID, String noteText, Boolean favourite) {
        Note note = noteRepository.findById(noteID)
                .orElseThrow(() -> new IllegalStateException("Note with ID " + noteID + "does not exist"));
        if (noteText != null && noteText.length() > 0 && !Objects.equals(note.getNote(), noteText)) {
            note.setNote(noteText);
        }
        if (!Objects.equals(note.isFavourite(), favourite)) {
            note.setFavourite(favourite);
        }

    }
    public Note getNote(Long noteId) {
        Optional<Note> exists = noteRepository.findById(noteId);
        if (exists.isEmpty())
            throw new IllegalStateException("Note with ID " + noteId + " does not exist!");

        return exists.get();
    }

    public List<Note> getNotesByUser(long userId) {
        List<Note> vratenie = noteRepository.findNotesByUserId(userId);
        return vratenie;
    }
}
