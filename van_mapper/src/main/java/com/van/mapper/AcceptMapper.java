package com.van.mapper;

import com.van.page.Page;
import com.van.pojo.Accept;
import com.van.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcceptMapper {

    List<Accept> findAllAccept(Page page);

    //查询总记录数
    Integer queryPageCount(Page page);

    List<Accept> findAllID_Name();
    /**
     * 修改收货人
     * @param accept
     */
    void  updateOrder(Accept accept);



}