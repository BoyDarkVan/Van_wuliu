package com.van.service;

import com.van.page.Page;
import com.van.pojo.Accept;
import java.util.List;

public interface AcceptService {
    /**
     * 查询所有收货人（分页查询）
     * @return
     */

    List<Accept> findAllID_Name();

    List<Accept> findAllAccept(Page page);

    Integer selectPageCount(Page page);

    void  updateAccept(Accept accept);
}
