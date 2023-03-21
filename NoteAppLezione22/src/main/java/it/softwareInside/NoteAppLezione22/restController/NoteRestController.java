package it.softwareInside.NoteAppLezione22.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.services.NoteService;

@RestController
public class NoteRestController {
	
	@Autowired
	NoteService noteService;
	
	
	@PostMapping("/addNote")
	public boolean addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}
	
	@DeleteMapping("/deleteNote")
	public boolean deleteNote(@RequestParam int id) {
		return noteService.removeNote(id);
	}
	
	@GetMapping("/list")
	public Iterable<Note> listNotes() {
		return noteService.listAllNotes();
	}
	
	@GetMapping("/getNoteById")
	public String getNoteById(@RequestParam int id) {
		return noteService.getNoteById(id);
	}
	
	@PostMapping("/updateNote")
	public boolean updateNote(@RequestBody Note note) {
		return noteService.updateNote(note);
	}
}
