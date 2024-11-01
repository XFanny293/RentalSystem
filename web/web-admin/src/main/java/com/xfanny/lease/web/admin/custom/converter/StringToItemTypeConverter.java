package com.xfanny.lease.web.admin.custom.converter;

import com.xfanny.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * ClassName: StringToItemTypeConverter
 * Package: com.xfanny.lease.web.admin.custom.converter
 * Description: 类型转换器（把字符串 转换为 枚举类）
 *
 * @Author XFanny
 * @Create 2024/10/31 15:17
 */
@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {
    /**
     *
     * @param source 元数据（前端传过来的type值）
     *        ItemType 目标类型
     * @return 把匹配到的具体的枚举类型返回给控制器方法的参数
     */
    @Override
    public ItemType convert(String source) {
        /**
         * value 相当于 APARTMENT(1,"公寓"),或者 ROOM(2,"房间")
         */
        for (ItemType value : ItemType.values()) {
            if (value.getCode().equals(Integer.parseInt(source))){
                return value;
            }
        }
        throw new IllegalArgumentException("非法参数");
    }
}
