package com.filehandler.service;

import org.springframework.web.multipart.MultipartFile;

import com.filehandler.entity.FileMetaData;

public interface FileService {
	
	public long uploadFile(MultipartFile file);
	
	public FileMetaData findById(Long id);
}
