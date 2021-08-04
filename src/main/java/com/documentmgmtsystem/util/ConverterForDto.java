package com.documentmgmtsystem.util;

import com.documentmgmtsystem.dto.DocumentDto;
import com.documentmgmtsystem.entity.Document;
import org.springframework.stereotype.Component;

@Component
public class ConverterForDto {
    public DocumentDto documentToDocumentDto(Document document)
    {
        DocumentDto  documentDto = new DocumentDto();
        documentDto.setDocId(document.getDocId());
        documentDto.setDocName(document.getDocName());
        documentDto.setDate(document.getCreatedAt());
        documentDto.setDocType(document.getDocType());
        documentDto.setDocPath(document.getDocPath());
        documentDto.setDocSize(document.getDocSize());
        return documentDto;
    }

    public Document documentDtoToDocument(DocumentDto documentDto)
    {
        Document document = new Document();
        document.setDocId(documentDto.getDocId());
        document.setDocName(documentDto.getDocName());
        document.setDocType(documentDto.getDocType());
        document.setDocSize(documentDto.getDocSize());
        document.setCreatedAt(documentDto.getDate());
        document.setDocPath(documentDto.getDocPath());
        return document;
    }
}
