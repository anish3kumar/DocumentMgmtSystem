package com.documentmgmtsystem.controller;

import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.exception.DocumentNotFoundException;
import com.documentmgmtsystem.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
public class DocumentController {

    @Autowired
    public DocumentService documentService;
    @PostMapping("/document/add")
    public Document addDocument(@RequestParam("file")MultipartFile file,@RequestParam Long docId)
    {
        return documentService.addDocumentDetails(file,docId);
    }

    @GetMapping("/document/allDocuments")
    public ResponseEntity<List<Document>> getAllDocuments()
    {
       List<Document> list =documentService.getAllDocuments();
        if(list.size() <=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/document/{docId}")
    public ResponseEntity<Document> searchDocumentById(@PathVariable("docId") Long docId) throws DocumentNotFoundException
    {
        Document document = documentService.getDocumentById(docId);
        if(document == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(document));
    }

}
