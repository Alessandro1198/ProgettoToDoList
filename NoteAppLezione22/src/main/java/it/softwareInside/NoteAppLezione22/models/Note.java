package it.softwareInside.NoteAppLezione22.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Note {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name = "text")
	@NotEmpty@NotNull
	private String text;
	
	@Column(name = "author")
	@NotEmpty@NotNull
	private String author;

	
	public Note() {
		this("","");
	}
	
	public Note(@NotEmpty @NotNull String text, @NotEmpty @NotNull String author) {
		this.text = text;
		this.author = author;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
