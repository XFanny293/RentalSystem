package com.xfanny.lease.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.Data;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: MybatisMetaObjectHandler
 * Package: com.xfanny.lease.common.mybatisplus
 * Description: 对 添加|修改 日期进行值填充
 *
 * @Author XFanny
 * @Create 2024/10/31 13:26
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    /**
     * 对标注了fill=FieldFill.INSERT的属性进行填充
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updateTime", Date.class,new Date());
    }
}
