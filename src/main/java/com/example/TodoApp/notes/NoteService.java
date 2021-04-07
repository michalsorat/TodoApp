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

    public void addNewNote(Note note) {
        noteRepository.save(note);
    }

    public boolean deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    @Transactional
    public Note updateNote(long id, Note updNote) {
        if (noteRepository.findById(id).isPresent())
        {
            Note existingNote = noteRepository.findById(id).get();
            if (updNote.getNote() != null && !Objects.equals(existingNote.getNote(), updNote.getNote()))
            {
                existingNote.setNote(updNote.getNote());
            }
            if (updNote.getDescription() != null && !Objects.equals(existingNote.getDescription(), updNote.getDescription()))
            {
                existingNote.setDescription(updNote.getDescription());
            }
            if (updNote.getFromDate() != null && !Objects.equals(existingNote.getFromDate(), updNote.getFromDate()))
            {
                existingNote.setFromDate(updNote.getFromDate());
            }
            if (updNote.getToDate() != null && !Objects.equals(existingNote.getToDate(), updNote.getToDate()))
            {
                existingNote.setToDate(updNote.getToDate());
            }
            if (!Objects.equals(existingNote.isFavourite(), updNote.isFavourite()))
            {
                existingNote.setFavourite(updNote.isFavourite());
            }
            return noteRepository.save(existingNote);
        }
        else
        {
            return null;
        }
    }


    public Note getNote(Long noteId) {
        if (noteRepository.existsById(noteId))
            return noteRepository.findById(noteId).get();
        else
            return null;
    }

    public List<Note> getNotesByUser(long userId) {
        //List<Note> notesOfUser = noteRepository.findNotesByUserId(userId);
        return noteRepository.findNotesByUserId(userId);
    }
}
