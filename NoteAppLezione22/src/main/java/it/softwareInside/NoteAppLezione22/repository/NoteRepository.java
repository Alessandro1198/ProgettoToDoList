package it.softwareInside.NoteAppLezione22.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareInside.NoteAppLezione22.models.Note;

public interface NoteRepository extends CrudRepository<Note, Integer>{

}
