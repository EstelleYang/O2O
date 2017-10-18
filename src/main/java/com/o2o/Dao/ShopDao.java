package com.o2o.Dao;

import com.o2o.DO.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {
    //新增店铺
    int insertShop(Shop shop);
    //更新店铺信息
    int updateShop(Shop shop);
}
