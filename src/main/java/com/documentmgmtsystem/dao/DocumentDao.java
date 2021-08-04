package com.documentmgmtsystem.dao;

import com.documentmgmtsystem.entity.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends JpaRepository<Document,Long>, PagingAndSortingRepository<Document,Long> {
    Page<Document> finaAll(Pageable pageable);
    public Document findByDocName(String docName);
    public Document findByDocId(Long docId);
}
