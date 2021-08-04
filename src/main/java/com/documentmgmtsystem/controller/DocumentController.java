package com.documentmgmtsystem.controller;

import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.exception.DocumentNotFoundException;
import com.documentmgmtsystem.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/document/add")
    public Document addDocument(@RequestParam("file")MultipartFile file,@RequestParam Long docId)//request body document name caller service
             //type sub type
    {
        return documentService.addDocumentDetails(file,docId);
    }

    @GetMapping("/document/allDocuments")
    public Page<Document> getAllDocuments(Pageable page) throws  DocumentNotFoundException
    {
        return documentService.getAllDocuments(page);
    }

    @GetMapping("/document/{docId}")
    public Document searchDocumentById(@PathVariable("docId") Long docId) throws DocumentNotFoundException
    {
        return documentService.getDocumentById(docId);
    }

}
