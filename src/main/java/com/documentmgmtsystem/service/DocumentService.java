package com.documentmgmtsystem.service;

import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.exception.DocumentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {

    public Document addDocumentDetails(MultipartFile file, Long docId);
    //public Page<Document> getAllDocuments();

    Page<Document> getAllDocuments(Pageable pageable) throws DocumentNotFoundException;

    public Document getDocumentById(Long docID) throws DocumentNotFoundException;
}
