package com.xfanny.lease.web.admin.custom.config;

import com.xfanny.lease.web.admin.custom.converter.StringToItemTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebMvcConfiguration
 * Package: com.xfanny.lease.web.admin.custom.config
 * Description: springmvc的配置类
 *
 * @Author XFanny
 * @Create 2024/10/31 15:36
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private StringToItemTypeConverter stringToItemTypeConverter;

    /**
     * 向SpringMVC的类型转换器WebDataBinder 注册自定义的类型转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(this.stringToItemTypeConverter);
    }
}
