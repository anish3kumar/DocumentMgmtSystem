package com.documentmgmtsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDto {
    private Long docId;
    private String docName;
    private String docType;
    private long docSize;
    private Date date;
    private String docPath;
}
