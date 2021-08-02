package com.documentmgmtsystem.dao;

import com.documentmgmtsystem.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends JpaRepository<Document,Long> {
    public Document findByDocName(String docName);
    public Document findByDocId(Long docId);
}
