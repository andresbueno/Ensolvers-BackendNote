package com.ensolvers.note.application;

import com.ensolvers.note.domain.model.Note;
import com.ensolvers.note.domain.repository.NoteRepository;
import com.ensolvers.note.infrastructure.dto.NoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(NoteRequest request){
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setIsArchived(false);
        return noteRepository.save(note);
    }

    public String deleteNote(Long id) {
        noteRepository.deleteById(id);
        return "Delete successfully "+id;
    }

    public String editNote(Long id, NoteRequest request) {
        Note note = noteRepository.findById(id).orElseThrow();
        if(request.getTitle()!=null &&  !request.getTitle().isEmpty()){
            note.setTitle(request.getTitle());
        }
        if(request.getContent()!= null && !request.getContent().isEmpty()){
            note.setContent(request.getContent());
        }
        noteRepository.save(note);
        return "edit successfully";
    }

    public List<Note> listNotes(Boolean archived) {
        if(archived==null){
            return noteRepository.findAll();
        }else{
            return noteRepository.findAll().stream().filter(note->note.getIsArchived()==archived).toList();
        }
    }

    public String archiveNote(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setIsArchived(!note.getIsArchived());
        noteRepository.save(note);
        return "status updated successfully";
    }
}