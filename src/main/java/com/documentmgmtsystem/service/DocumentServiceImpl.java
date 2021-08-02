package com.documentmgmtsystem.service;

import com.documentmgmtsystem.dao.DocumentDao;
import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.uploadhelper.DocumentUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    public DocumentDao documentDao;

    @Autowired
    public DocumentUploadHelper documentUploadHelper;

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
    public List<Document> getAllDocuments() {

        return documentDao.findAll();
    }

    @Override
    public Document getDocumentById(Long docID) {
        return documentDao.findByDocId(docID);
    }
}
