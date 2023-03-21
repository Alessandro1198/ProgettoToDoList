# ProgettoToDoList

Prgetto realizzato con Spring Boot e Hibernate.
Piccolo progetto che registra delle note su un server locale e tramite una GET scarica un PDF contenente le varie note all'interno del database.


Il progetto è formato da:

-main, dal quale avviare il server in locale.

-classe pojo chiamata Note che serve da template per le note da aggiungere al database.

-repository che contiene l'interfaccia che servirà a rendere accessibili tutti i metodi CRUD relativi ad Note.

-noteService, che contiene tutta la logica dietro a tutte le operazioni da effettuare.

-pdfCreatorService, che contiene la logica dietro alla creazione di un PDF.

-NoteRestController, che serve a mappare i vari percorsi insieme ad i metodi GET,POST,DELETE.

-PdfGeneratorRestController, che serve a mappare i vari percorsi per scaricare il pdf con tutte le note del database, o in base all'id.





API utilizzata:
"<dependency>
			<groupId>com.github.librepdf</groupId>
			<artifactId>openpdf</artifactId>
			<version>1.3.8</version>
</dependency>"
