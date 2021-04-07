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
        Optional<Note> exists = noteRepository.findById(noteId);
        if (exists.isEmpty())
            throw new IllegalStateException("Note with ID " + noteId + " does not exist!");

        return exists.get();
    }

    public List<Note> getNotesByUser(long userId) {
        //List<Note> notesOfUser = noteRepository.findNotesByUserId(userId);
        return noteRepository.findNotesByUserId(userId);
    }
}
