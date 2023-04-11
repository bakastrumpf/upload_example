package com.iktpreobuka.uploadexampletwo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// ovoj klasi se prosleđuju sve greške koje se uhvate u THROWS IOEXCEPTION
@ControllerAdvice
public class GlobalExceptionHandler {

	// ako nema ove metode (ako je zakomentarišemo), korisniku će se pojaviti WHITE LABEL ERROR ili tako nešto
	// hvata MULTIPARTEXCEPTION
	// u ovom primeru, MultipartException je nadklasa svih izuzetaka koji mogu da se dese prilikom aplouda multipart fajlova
	@ExceptionHandler(MultipartException.class)
	public String handleException(MultipartException e, RedirectAttributes redirectAttributes) {
		
		// ne želimo samo da uhvatimo grešku (statusni kod) nego i da kažemo korisniku kakva je greška u pitanju
		redirectAttributes.addFlashAttribute("message", "File too large! Please upload a different file!");
		// na kraju korisnika preusmeravamo na status slanja fajla:
		return "redirect:/uploadStatus";

		// redirectAttributes.addFlashAttribute("message",
		// e.getCause().getMessage());
		// return "redirect:/uploadStatus";

	}

}
