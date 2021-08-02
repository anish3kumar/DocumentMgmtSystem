package com.documentmgmtsystem;

import com.documentmgmtsystem.dao.DocumentDao;
import com.documentmgmtsystem.entity.Document;
import com.documentmgmtsystem.service.DocumentService;
import com.documentmgmtsystem.uploadhelper.DocumentUploadHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DocumentMgmtSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DocumentService documentService;

    @MockBean
    private DocumentDao documentDao;

    @MockBean
    private DocumentUploadHelper documentUploadHelper;
    @Test
    public void getAllDocuments()
    {
        when(documentDao.findAll()).thenReturn(Stream.of(new Document(1l,"test","pdf",22,new Date(),"test/path"),
                new Document(2l,"test2","img",33,new Date(),"test2/path")).collect(Collectors.toList()));
        assertEquals(2,documentService.getAllDocuments().size());
    }
    @Test
    public void getDocumentById()
    {
        Long docId = 2l;
       //
        when(documentDao.findByDocId(docId)).thenReturn(new Document(2l,"test2","img",33,new Date(),"test2/path"));
        Document document = documentDao.findByDocId(docId);
        //assertEquals(2l,document.getDocId());
        assertEquals("test2",document.getDocName());
        assertEquals("img",document.getDocType());
        assertEquals(33,document.getDocSize());
        assertEquals(new Date(),new Date());
        assertEquals("test2/path",document.getDocPath());

    }
    @Test
    public void addDocumentDetails() throws IOException {
        Long docId = 2l;
        MultipartFile multipartFile = new MockMultipartFile("test.txt",new FileInputStream(new File("/home/anishkumar/test.txt")));
        documentUploadHelper.uploadDoc(multipartFile);
        Document document = new Document(2l,"test2","img",33,new Date(),"test2/path");
        documentDao.save(document);
        //when(documentDao.save(document)).thenReturn(document);
        verify(documentDao,times(1)).save(document);
    }
}
