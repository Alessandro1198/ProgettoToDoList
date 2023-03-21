package it.softwareInside.NoteAppLezione22.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.repository.NoteRepository;
import jakarta.validation.Valid;

@Service
public class NoteService {
	
	@Autowired
	NoteRepository noteRepository;
	
	
	public boolean addNote(@Valid Note note) {
		
		try {
			noteRepository.save(note);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean removeNote(@Valid int id) {
		
		try {
			Note note = noteRepository.findById(id).get();
			noteRepository.delete(note);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Iterable<Note> listAllNotes() {
		
		try {
			return noteRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getNoteById(@Valid int id) {
		
		try {
			Note note = noteRepository.findById(id).get();
			return note.getText();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean updateNote(@Valid Note note) {
		return addNote(note);
	}
}
