package com.filehandler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.filehandler.entity.FileMetaData;
import com.filehandler.service.FileService;

@RestController
@RequestMapping("/files")
public class FileHandlerController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FileService service;
	
	@PostMapping(value="/upload")
	public Long save(final @RequestParam("file") MultipartFile file) {
		System.out.println("uploading file and saving meta data info");
		return service.uploadFile(file);
	}
	
	@GetMapping(value="/{id}")
	public FileMetaData findById(@PathVariable("id") Long id) {
		
		return service.findById(id);
	}
}
