package com.xfanny.lease.web.admin.service;

import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
* ClassName: FileUploadService
* Package: com.xfanny.lease.web.admin.service
* Description: 
* @Author XFanny
* @Create 2024/11/1 19:27 
*/public interface FileUploadService {
    String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
