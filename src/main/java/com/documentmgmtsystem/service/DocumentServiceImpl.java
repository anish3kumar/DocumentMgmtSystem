package com.documentmgmtsystem.service;

import com.documentmgmtsystem.dao.DocumentDao;
import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.exception.DocumentNotFoundException;
import com.documentmgmtsystem.uploadhelper.DocumentUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DocumentUploadHelper documentUploadHelper;

    @Autowired
    private Environment environment;

    @Override
    public Document addDocumentDetails(MultipartFile file, Long docId) {
        Document document = new Document();
        document.setDocId(docId);
        document.setDocName(file.getOriginalFilename());
        document.setDocType(file.getContentType());
        document.setDocSize(file.getSize());
        document.setCreatedAt(new Date());
        document.setDocPath(ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/documents");
        boolean checkUpload = documentUploadHelper.uploadDoc(file) ;
        return documentDao.save(document);
    }

    @Override
    public Page<Document> getAllDocuments(Pageable pageable) throws DocumentNotFoundException {
        Optional<Page<Document>> document = Optional.ofNullable(documentDao.finaAll(pageable));
        if(!document.isPresent())
        {
            throw new DocumentNotFoundException("list is empty");
        }
        return documentDao.findAll(pageable);
    }


    @Override
    public Document getDocumentById(Long docID) throws DocumentNotFoundException {
       Optional<Document> document  = Optional.ofNullable(documentDao.findByDocId(docID));
       if(!document.isPresent())
       {
           throw new DocumentNotFoundException("Document is not present");
       }

       return documentDao.findByDocId(docID);
    }
}
