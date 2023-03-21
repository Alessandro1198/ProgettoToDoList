package it.softwareInside.NoteAppLezione22.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import it.softwareInside.NoteAppLezione22.models.Note;
import it.softwareInside.NoteAppLezione22.repository.NoteRepository;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class PdfGeneratorService {
	
	@Autowired
	NoteRepository noteRepository;
	
	public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        
        
        Paragraph paragraphTitle = new Paragraph("This is a title.", fontTitle);
        paragraphTitle.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        
        document.add(paragraphTitle);

        String ris = "";
        for (Note note : noteRepository.findAll()) {
        	ris = note.getText();
        	Paragraph paragraph = new Paragraph(ris, fontParagraph);
            paragraph.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(paragraph);
        }
        

        document.close();
    }
	
	public void export2(HttpServletResponse response, int id) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        
        
        Paragraph paragraphTitle = new Paragraph("This is a title.", fontTitle);
        paragraphTitle.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        
        document.add(paragraphTitle);

        String ris = "";
        Note note = noteRepository.findById(id).get();
        ris = note.getText();
        Paragraph paragraph = new Paragraph(ris, fontParagraph);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph);
        

        document.close();
    }
}
