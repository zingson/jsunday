package com.ul.biz.waimai.mapper;

import com.ul.biz.waimai.model.WmOrderDetail;
import java.util.List;

public interface WmOrderDetailMapper {
    int insert(WmOrderDetail record);

    List<WmOrderDetail> selectAll();
}