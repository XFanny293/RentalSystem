package com.xfanny.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisPlusConfiguration
 * Package: com.xfanny.lease.common.mybatisplus
 * Description:
 *
 * @Author XFanny
 * @Create 2024/10/30 20:58
 */
@Configuration
@MapperScan("com.xfanny.lease.web.*.mapper")
public class MybatisPlusConfiguration {
}
