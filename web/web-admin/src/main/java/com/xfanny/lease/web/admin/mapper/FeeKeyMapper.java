package com.xfanny.lease.web.admin.mapper;

import com.xfanny.lease.model.entity.FeeKey;
import com.xfanny.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author liubo
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Mapper
* @createDate 2023-07-24 15:48:00
* @Entity com.xfanny.lease.model.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {


    List<FeeKeyVo> feeInfoList();
}




