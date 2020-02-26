package com.filehandler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filehandler.entity.FileMetaData;

@Repository
public interface FileRepository extends CrudRepository<FileMetaData, Long>{
	
}
