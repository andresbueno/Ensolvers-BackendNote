package com.ensolvers.note.domain.repository;

import com.ensolvers.note.domain.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
