package com.unionlive.waimai.mapper;

import com.unionlive.waimai.model.UltabWmOrderInfo;
import java.util.List;

public interface UltabWmOrderInfoMapper {
    int insert(UltabWmOrderInfo record);

    List<UltabWmOrderInfo> selectAll();
}