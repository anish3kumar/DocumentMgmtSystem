package com.documentmgmtsystem.uploadhelper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class DocumentUploadHelper {
    public final String uploadDir ="/home/anishkumar/DocumentMgmntSystem/src/main/resources/static/documents";
    public boolean uploadDoc(MultipartFile file)
    {
        boolean checkUpload = false;
        try
        {
            Files.copy(file.getInputStream(), Paths.get(uploadDir+ File.separator +file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            checkUpload = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return checkUpload;
    }
}
