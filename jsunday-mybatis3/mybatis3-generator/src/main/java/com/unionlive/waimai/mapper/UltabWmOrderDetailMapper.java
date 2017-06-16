package com.unionlive.waimai.mapper;

import com.unionlive.waimai.model.UltabWmOrderDetail;
import java.util.List;

public interface UltabWmOrderDetailMapper {
    int insert(UltabWmOrderDetail record);

    List<UltabWmOrderDetail> selectAll();
}