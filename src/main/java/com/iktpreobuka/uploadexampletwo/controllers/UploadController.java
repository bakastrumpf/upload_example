package com.iktpreobuka.uploadexampletwo.controllers;

import java.io.IOException;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iktpreobuka.uploadexampletwo.services.FileHandler;

@Controller
@RequestMapping("/")
public class UploadController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// (import org.slf4j.Logger; 
	// import org.slf4j.LoggerFactory;)
	
	@Autowired
	private FileHandler fileHandler;
	
	// vraća string UPLOAD koji je zapravo template UPLOAD.HTML
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "upload";
	}

	// vraća string UPLOADSTATUS koji je zapravo template UPLOADSTATUS.HTML
	@RequestMapping(method = RequestMethod.GET, path = "/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {
		logger.debug("This is a debug message!");
		logger.info("This is an info message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		String result = null;
		result = fileHandler.singleFileUpload(file, redirectAttributes);
		return result;
	
//		try {
//			result = fileHandler.singleFileUpload(file, redirectAttributes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
		
		// return null;
	}
}
