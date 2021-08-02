package com.documentmgmtsystem.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Table(name ="document")
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long docId;

    @Column(name ="doc_name")
    private String docName;

    @Column(name ="doc_type")
    private String docType;

    @Column(name ="doc_size")
    private long docSize;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="doc_path")
    private String docPath;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public long getDocSize() {
        return docSize;
    }

    public void setSize(long docSize) {
        this.docSize = docSize;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public Document() {
    }


    public Document(Long docId, String docName, String docType, long docSize, Date createdAt, String docPath) {
        this.docId = docId;
        this.docName = docName;
        this.docType = docType;
        this.docSize = docSize;
        this.createdAt = createdAt;
        this.docPath = docPath;
    }
}
