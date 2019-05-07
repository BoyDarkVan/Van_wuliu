package com.van.service;

import com.van.page.Page;
import com.van.pojo.Store;

import java.util.List;


/**
 * 仓库业务接口，钟恒把实现类给我写了,可以参照我货单的
 */
public interface StoreService {
    /**
     * 查询所有存储信息（分页查询）
     * @return
     */
    List<Store> findAllStore(Page page);

    Integer findTotal(Page page);

    void delStore(String s_id);

    /**
     * 添加仓库传一个存储对象过来
     * @param store
     */
    void  addStore(Store store);


//  更新储存数量
    void updStore(Store store);
}
