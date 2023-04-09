package com.iktpreobuka.uploadexampletwo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MultipartException.class)
	public String handleException(MultipartException e, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "File too large! Please upload a different file!");
		return "redirect:/uploadStatus";

		// redirectAttributes.addFlashAttribute("message",
		// e.getCause().getMessage());
		// return "redirect:/uploadStatus";

	}

}
