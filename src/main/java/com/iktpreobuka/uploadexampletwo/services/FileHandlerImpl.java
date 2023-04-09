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
	
	private static String UPLOAD_FOLDER = "C:/home/montekrista/Desktop";

	@Override
	public String singleFileUpload(MultipartFile file, 
			RedirectAttributes redirectAttributes) {
		// TODO da li je fajl prazan
		if (file.isEmpty()) {
			// TODO ako jeste, odradimo redirekciju odgovarajućm porukom
			redirectAttributes.addFlashAttribute("message", "Please, select file  to upload");
			return "redirect.uploadStatus";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get("UPLOAD_FOLDER + file.getOriginalFileName()");
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message", "File" 
			+ file.getOriginalFilename() + " successfully uploaded!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//throw e;
			e.printStackTrace();
		}
		
		// TODO ako nije prazan, sačuvamo ga
		// TODO odradimo redirekciju koja kaže da je fajl postavljen
		return "redirect:/uploadStatus";
	}
}