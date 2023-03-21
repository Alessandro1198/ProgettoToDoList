package it.softwareInside.NoteAppLezione22.restController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.NoteAppLezione22.services.PdfGeneratorService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PdfGeneratorRestController {
	
	
	@Autowired
	PdfGeneratorService pdfGeneratorService;
	
	@GetMapping("/pdf/generate")
	public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response);
    }
	
	@GetMapping("pdf/generateById")
	public void generatePDFbyId(HttpServletResponse response, @RequestParam int id) throws IOException{
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export2(response, id);
	}
}
