package com.xfanny.lease.web.admin.service.impl;

import com.xfanny.lease.common.minio.MinioProperties;
import com.xfanny.lease.web.admin.service.FileUploadService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName: FileUploadServiceImpl
 * Package: com.xfanny.lease.web.admin.service.impl
 * Description:
 *
 * @Author XFanny
 * @Create 2024/11/1 19:28
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private MinioProperties minioProperties;

    @Autowired
    private MinioClient minioClient; //有问题

    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        boolean res = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
        if (!res) {
            // 创建桶
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            // 设置桶的访问权限
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder()
                    .bucket(minioProperties.getBucketName())
                    .config(createBucketPolicyConfig(minioProperties.getBucketName())).
                    build());
        } else {
            System.out.println("桶存在");
        }
        // 原始的文件名
        String originalFilename = file.getOriginalFilename();
        // 新的文件名
        String newFileName = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + UUID.randomUUID() + "-" + originalFilename;
        // 上传文件
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucketName())
                .object(newFileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build());
        System.out.println("文件上传成功");
//            return minioProperties.getEndpoint() + "/" + minioProperties.getBucketName() + "/" + newFileName;
        return String.join("/", minioProperties.getEndpoint(), minioProperties.getBucketName(), newFileName);

    }
    /**
     * 给桶设置访问权限
     * @param bucketName 桶名
     *                   %s 占位符，用于替换桶名
     * @return
     */
    private String createBucketPolicyConfig(String bucketName) {

        return """
            {
              "Statement" : [ {
                "Action" : "s3:GetObject",
                "Effect" : "Allow",
                "Principal" : "*",
                "Resource" : "arn:aws:s3:::%s/*"
              } ],
              "Version" : "2012-10-17"
            }
            """.formatted(bucketName);
    }
}
