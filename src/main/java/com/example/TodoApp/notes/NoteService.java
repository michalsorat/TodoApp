package com.example.TodoApp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Note addNewNote(Note note) {
        if (note.getNote() != null && !note.getNote().isEmpty()) {
            return noteRepository.save(note);
        }
        else
            throw new IllegalStateException("Missing input");
    }

    public void deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        }
        else
            throw new IllegalStateException("Note with id " + id + " does not exist");
    }

    @Transactional
    public Note updateNote(long id, Note updNote) {
        if (noteRepository.findById(id).isPresent())
        {
            Note existingNote = noteRepository.findById(id).get();
            if (updNote.getNote() != null && !Objects.equals(existingNote.getNote(), updNote.getNote())) {
                existingNote.setNote(updNote.getNote());
            }
            if (updNote.getDescription() != null && !Objects.equals(existingNote.getDescription(), updNote.getDescription())) {
                existingNote.setDescription(updNote.getDescription());
            }
            if (updNote.getFromDate() != null && !Objects.equals(existingNote.getFromDate(), updNote.getFromDate())) {
                existingNote.setFromDate(updNote.getFromDate());
            }
            if (updNote.getToDate() != null && !Objects.equals(existingNote.getToDate(), updNote.getToDate())) {
                existingNote.setToDate(updNote.getToDate());
            }
            if (!Objects.equals(existingNote.isFavourite(), updNote.isFavourite())) {
                existingNote.setFavourite(updNote.isFavourite());
            }
            return noteRepository.save(existingNote);
        }
        else
        {
            throw new IllegalStateException("Note with id " + id + " does not exist");
        }
    }


    public Note getNote(Long noteId) {
        Optional<Note> exists = noteRepository.findById(noteId);
        if (exists.isEmpty())
            throw new IllegalStateException("Note with id " + noteId + " does not exist");
        return exists.get();
    }

    public List<Note> getNotesByUser(long userId) {
        return noteRepository.findNotesByUserId(userId);
    }
}
