package com.xfanny.lease.web.admin.service.impl;

import com.xfanny.lease.model.entity.FeeKey;
import com.xfanny.lease.web.admin.mapper.FeeKeyMapper;
import com.xfanny.lease.web.admin.service.FeeKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author liubo
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2023-07-24 15:48:00
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{

}



