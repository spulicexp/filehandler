package com.filehandler.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.filehandler.entity.FileMetaData;
import com.filehandler.exception.FileException;
import com.filehandler.exception.FileRetrivalException;
import com.filehandler.repository.FileRepository;
import com.filehandler.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Value("${file.upload.path}")
	private String path;
	
	private static int SIZE_TO_MB = 1024;
	
	
	@Autowired
	FileRepository fileRepository;
	 
	@Override
	public long uploadFile(MultipartFile file) {
		
		FileMetaData data = new FileMetaData();
		
		try {
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            
            data.setName(file.getOriginalFilename());
    		data.setType(file.getContentType());
    		data.setSize(Double.valueOf(file.getSize()/SIZE_TO_MB));
    		
    		long fileId = save(data);
    		
    		return fileId;
    		
        } catch (IOException e) {

            String msg = String.format("Failed to save the file", file.getName());

            throw new FileException(msg, e);
        }
		
	}
	
	//save files metadata
	public long save(final FileMetaData metadata) {
		FileMetaData info = fileRepository.save(metadata);
		return info.getId();
	}
	
	//retrieve file metadata by fileId
	public FileMetaData findById(Long id) {
		Optional<FileMetaData> metaData = fileRepository.findById(id);
		
		if(metaData.isPresent()) {
			return metaData.get();
		} 
		
		throw new FileRetrivalException("Failed to retrive file metadata");
		
	}
	
}
