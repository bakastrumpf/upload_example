package com.iktpreobuka.uploadexampletwo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class FileHandlerImpl implements FileHandler {
	
	
	// UPLOAD_FOLDER = "C:\\SpringTemp\\";
	private static String UPLOAD_FOLDER = "C:/home/montekrista/Desktop";

	@Override
	// klasičan kontroler
	public String singleFileUpload(MultipartFile file, 
		// kroz redirectAttributes preko UPLOAD.HTML šaljemo poruku o statusu slanja fajla na UPLOADSTATUS.HTML
			RedirectAttributes redirectAttributes) {
		// TODO da li je fajl prazan
		if (file.isEmpty()) {
		// TODO ako jeste, odradimo preusmerenje sa odgovarajućm porukom
			redirectAttributes.addFlashAttribute("message", "Please, select file to upload");
			return "redirect.uploadStatus";
		}
		try {
			// pošto ne znamo u kom je obliku fajl, uvek možemo da ga posmatramo kao BINARNI FAJL
			byte[] bytes = file.getBytes();
			// ako korisnik pošalje fajl s istim imenom, pregaziće stari 
			// možemo dodati timestamp radi razlikovanja
			Path path = Paths.get("UPLOAD_FOLDER + file.getOriginalFileName()");
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message", "Congrats! File " 
			+ file.getOriginalFilename() 
			+ " successfully uploaded!");
		} catch (IOException e) {
			//throw e;
			e.printStackTrace();
		}
		// TODO ako nije prazan, sačuvamo ga
		// TODO odradimo preusmerenje koja kaže da je fajl postavljen
		return "redirect:/uploadStatus";
	}
	
	
}