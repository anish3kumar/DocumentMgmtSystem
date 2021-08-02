package com.documentmgmtsystem.service;

import com.documentmgmtsystem.entity.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {

    public Document addDocumentDetails(MultipartFile file, Long docId);
    public List<Document> getAllDocuments();
    public Document getDocumentById(Long docID);
}
