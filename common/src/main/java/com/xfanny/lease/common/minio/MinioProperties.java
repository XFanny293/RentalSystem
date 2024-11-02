package com.xfanny.lease.common.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: MinioProperties
 * Package: com.xfanny.lease.common.minio
 * Description: minio 配置
 *
 * @Author XFanny
 * @Create 2024/11/1 18:58
 */
@Component
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
